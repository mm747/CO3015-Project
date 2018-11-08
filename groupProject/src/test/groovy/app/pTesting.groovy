package app

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.ResultActions
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


import portal.controller.*;
import portal.repository.RoleRepository
import portal.repository.UserInfoRepository
import spock.lang.Specification
import spock.lang.Unroll
import portal.*;


@ContextConfiguration (classes = [WebConfig.class,PortalApp.class])
@WebMvcTest(controllers=[IndexController.class,PersonalProfileController.class,LoginController.class,RegisterController.class])
class pTesting extends Specification{

	@MockBean
	private RoleRepository roleRepo;
	@MockBean
	private UserInfoRepository userRepo;
	@Autowired
	def WebApplicationContext wac
	
	def MockMvc mockMvc
	def ResultActions result
	
	def "1"() {
		given: "the context of the controller is set up"
			mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
		when: "I do a get '/system'"
			result = this.mockMvc.perform(get('/system'));
		then: "I should see the view 'index'"
			result
			.andExpect(status().isOk())
			.andExpect(view().name('index'));
	}
	
	
	def "2"() {
		given: "the context of the controller is set up"
			mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
		when: "I do a get /profile/"
			result = this.mockMvc.perform(get('/profile/'));
		then: "I should see the view 'form/personalProfile'"
			result
				.andExpect(status().isOk())
				.andExpect(view().name('form/personalProfile'));
	}
	
	def "3"() {
		given:"the web application context"
		mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
		when: "I do a get '/'"
		result = mockMvc.perform(get("/"));
		then: "I should see the view 'Landing'"
			result.andExpect(status().is(200)).andExpect(view().name('Landing'));
	}
	
	def "4"(){
		given: "the context of the controller is set up"
		mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
		when: "I do a get '/login-form'"
		result = this.mockMvc.perform(get('/login-form'));
		then: "I should see the view 'login-form"
		result
		.andExpect(status().isOk())
		.andExpect(view().name('login-form'));
	}
	
	
	def"5"(){
		given: "the context of the controller is set up"
		mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
		when: "I do a get '/logoff'"
		result = this.mockMvc.perform(get('/logoff'));
		then: "I should see the view 'Landing"
		result
		.andExpect(status().isOk())
		.andExpect(view().name('Landing'));
	}
	


}