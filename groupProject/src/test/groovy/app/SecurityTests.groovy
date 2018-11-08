package app;

import static portal.PortalApp.*
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.*;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.*;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import portal.SecurityConfig;
import portal.repository.RoleRepository;
import portal.repository.UserInfoRepository;
import portal.*;
import portal.controller.*;
import portal.domain.*;
import portal.services.CustomUserDetailsService;
import spock.lang.Specification;
import spock.lang.Unroll

@SpringBootTest(webEnvironment=WebEnvironment.DEFINED_PORT,classes=[PortalApp.class,DbConfig.class,SecurityConfig.class,WebConfig.class,LoginController.class,IndexController.class,OrderController.class,RegisterController.class,CustomUserDetailsService.class])
@AutoConfigureMockMvc(secure=false)
class SecurityTests extends Specification {

	@MockBean
	private RoleRepository roleRepo;
	@MockBean
	private UserInfoRepository userRepo;
	
	@Autowired
    private WebApplicationContext wac;
	
	private MockMvc mockMvc;
	private ResultActions result;
	
	def setup() {
		this.mockMvc = MockMvcBuilders
						.webAppContextSetup(this.wac)
						.apply(springSecurity())
						.build()
						
		Role ROLE_ADMIN = roleRepo.save(new Role(ADMIN,"ADMIN"));
		Role ROLE_USER = roleRepo.save(new Role(USER,"USER"));
		Role ROLE_PREMIUM = roleRepo.save(new Role(PREMIUM,"PREMIUM"));
					
		BCryptPasswordEncoder pe = new  BCryptPasswordEncoder();
		
		UserInfo user = new UserInfo();
	    user.setUsername("admin");
	    user.setPassword(pe.encode("admin"));
	    user.setRole(ROLE_ADMIN);
	    userRepo.save(user);
	   
	    user = new UserInfo();
	    user.setUsername("user");
	    user.setPassword(pe.encode("user"));
		user.setRole(ROLE_USER);
		userRepo.save(user);
	   
		user = new UserInfo();
		user.setUsername("premium");
	    user.setPassword(pe.encode("premium"));
	    user.setRole(ROLE_PREMIUM);
	    userRepo.save(user);
	}
	
	def "secureChannel"() {
		when:
			// commented out .secure( true )
			result = this.mockMvc.perform(get("/system").with(user("admin").roles("ADMIN")))
		then:
			result.andExpect(status().is(302))
				.andExpect(authenticated().withUsername("admin").withRoles("ADMIN"))
	}
	
	@Unroll
	def "authentication-#testId"() {
		when:
			// commented out
			if (valid) {
			} else {
				result = this.mockMvc.perform(formLogin().user("login",username).password("password",password))
			}
		then:
			if (valid) {
			} else {
				result.andExpect(unauthenticated())
			}
		where:
			testId | username | password | role | valid
			3 | "premium" | "invalid" | "PREMIUM" | false
			4 | "invalid" | "invalid" | "PREMIUM" | false
			
	}
	
	@Unroll
	def "authorization-#testId"() {
		when: "I perform a get #request"
			if (method == 'get')
				result = this.mockMvc.perform(get("$requestUrl").secure( true ).with(user(username).roles(role)))
			else
				if (requestUrl.startsWith('/signup/add'))
					result = this.mockMvc.perform(post("$requestUrl").param('add','').secure( true ).with(user(username).roles(role)))
				else
					result = this.mockMvc.perform(post("$requestUrl").secure( true ).with(user(username).roles(role)))
		then:
			result.andExpect(status().is(statusCode))
				.andExpect(authenticated().withUsername(username).withRoles(role))
		where:
			testId | method | requestUrl | username | role | statusCode
			1 | 'get' | '/system' | "admin" | "ADMIN" | 200
			2 | 'get' | '/system/' | "admin" | "ADMIN" | 200
			3 | 'get' | '/system' | "user" | "USER" | 403
			4 | 'get' | '/system/' | "user" | "USER" | 403
			5 | 'get' | '/system' | "premium" | "PREMIUM" | 403
			6 | 'get' | '/system/' | "premium" | "PREMIUM" | 403
			7 | 'get' | '/system/user' | "user" | "USER" | 200
			8 | 'get' | '/system/user/' | "user" | "USER" | 200
			9 | 'get' | '/system/user' | "premium" | "PREMIUM" | 200
			10 | 'get' | '/system/user/' | "premium" | "PREMIUM" | 200
			11 | 'get' | '/system/user' | "admin" | "ADMIN" | 403
			12 | 'get' | '/system/user/' | "admin" | "ADMIN" | 403
			13 | 'get' | '/system/premium' | "premium" | "PREMIUM" | 200
			14 | 'get' | '/system/premium/' | "premium" | "PREMIUM" | 200
			15 | 'get' | '/system/premium' | "user" | "USER" | 403
			16 | 'get' | '/system/premium/' | "user" | "USER" | 403
			17 | 'get' | '/system/premium' | "admin" | "ADMIN" | 403
			18 | 'get' | '/system/premium/' | "admin" | "ADMIN" | 403
			19 | 'post' | '/setDate' | "admin" | "ADMIN" | 200
			20 | 'post' | '/setDate/' | "admin" | "ADMIN" | 200
			21 | 'post' | '/setDate' |  "user" | "USER" | 403
			22 | 'post' | '/setDate/' |  "user" | "USER" | 403
			23 | 'post' | '/setDate' |  "premium" | "PREMIUM" | 403
			24 | 'post' | '/setDate/' |  "premium" | "PREMIUM" | 403
			
			25 | 'get' | '/status/statusDetail' | "user" | "USER" | 200
			26 | 'post' | '/status/add' | "user" | "USER" | 200
			27 | 'get' | '/status/delete' | "user" | "USER" | 200
			28 | 'get' | '/status/statusDetail' | "premium" | "PREMIUM" | 200
			29 | 'post' | '/status/add' | "premium" | "PREMIUM" | 200
			30 | 'get' | '/status/delete' | "premium" | "PREMIUM" | 200
		
	
	}
	
	
}
