package portal;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	DataSource dataSource;
	
	@Bean
	public PasswordEncoder passwordEncoder(){
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
	
	
	@Autowired 
	private UserDetailsService userDetailsService; 	

    @Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}
	
	
    protected void configure(HttpSecurity http) throws Exception {
    	http
    		// AUTHENTICATION AND AUTHORISATION
    		.csrf().disable() // if csrf is enabled, /logout must be a POST
    		.authorizeRequests()
    			.antMatchers("/setDate/**").hasRole("ADMIN")  // <-- authorisation
    			.antMatchers("/signup/**").permitAll()  // <-- authorisation
    			.antMatchers("/system").hasRole("ADMIN")  // <-- authorisation
    			.antMatchers("/system/").hasRole("ADMIN")  // <-- authorisation
    			.antMatchers("/system/user/**").hasAnyRole("USER", "PREMIUM")  // <-- authorisation
    			.antMatchers("/system/premium/**").hasRole("PREMIUM")  // <-- authorisation
//			.antMatchers("/product/**").hasRole("ADMIN")  // <-- authorisation
//			.antMatchers("/deal/**").hasRole("ADMIN")  // <-- authorisation
//			.antMatchers("/order").hasAnyRole("USER", "PREMIUM")  // <-- authorisation hasRole("USER") // .access("hasRole('USER') and hasRole('PREMIUM')") 
//			.antMatchers("/order/").hasAnyRole("USER", "PREMIUM")  // <-- authorisation hasRole("USER") // 
//			.antMatchers("/order/wishlist/**").hasRole("PREMIUM")  // <-- authorisation
    			.anyRequest().authenticated()
    	
		.and()
		    .formLogin()
		    .failureForwardUrl("/login-form")
				.loginPage("/login-form")
				.defaultSuccessUrl("/success-login",true) // the second parameter is for enforcing this url always
				.loginProcessingUrl("/login")
				.failureUrl("/login-form")
				.permitAll()
		.and()
			.logout()
				// .logoutUrl() // by deafault this is /logout and if CSRF is enabled the request has to be a POST
//				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//				.logoutSuccessUrl("/logoff")
				.invalidateHttpSession(true) 
				.permitAll()
		.and()
		    .exceptionHandling().accessDeniedPage("/access-denied")
//	        	.and()
//	        		.csrf()
	    .and()
	        // SECURE COMMUNICATION
		    .requiresChannel()
		    	.anyRequest()
		    	.requiresSecure();
    }
    
}
	