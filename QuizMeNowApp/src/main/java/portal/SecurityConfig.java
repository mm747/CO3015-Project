package portal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    protected void configure(HttpSecurity http) throws Exception {
    	http
        // enable a secure communication  	
	    	.requiresChannel ()
	    	.anyRequest()
	    	.requiresSecure().and()
    	// applying authentication 
		    .formLogin()
				.loginPage("/user-login") 
				.loginProcessingUrl("/login")
				.defaultSuccessUrl("/success-login",true)
				.failureUrl("/error-login")
				.permitAll()
		.and()
			.logout()
				.invalidateHttpSession(true)
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/user-login")
				.permitAll()
		// Applying authorisation
		.and()
			.authorizeRequests()
				.antMatchers("/list/**").hasAnyRole("USER", "TEACHER")
				.antMatchers("/create/**").hasRole("TEACHER")
				.antMatchers("/delete/**").hasAnyRole("ADMIN","TEACHER")
				.antMatchers("/admin/**").hasRole("ADMIN")
				.anyRequest().authenticated() // all requests ABOVE this statement require authentication
		.and()
			// to redirect the user when trying to access a resource to which access is not granted
	        .exceptionHandling().accessDeniedPage("/access-denied");
    }

	@Autowired 
	private UserDetailsService userDetailsService; 	
    //Applying BCrypt encryption
    @Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		BCryptPasswordEncoder pe = new  BCryptPasswordEncoder();
		auth.userDetailsService(userDetailsService).passwordEncoder(pe);
		
	}
    
}
	