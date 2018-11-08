package portal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.TimeZone;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


import portal.domain.UserInfo;
import portal.repository.UserInfoRepository;
import portal.domain.Role;
import portal.repository.RoleRepository;

@SpringBootApplication
public class PortalApp extends WebMvcConfigurerAdapter implements CommandLineRunner {

	@Autowired RoleRepository RoleRepo;
	
	@Autowired UserInfoRepository userRepo;
	

	private static LocalDate systemDate;
	
	public final static int ADMIN = 1;
	public final static int USER = 2;
	public final static int PREMIUM = 3;
	

	public static LocalDate getSystemDate() {
		return systemDate;
	}

	public static void setSystemDate(LocalDate systemDate) {
		PortalApp.systemDate = systemDate;
	}

	public static void main(String[] args) {
        SpringApplication.run(PortalApp.class, args);
    }

	@Transactional
    public void run(String... args) {
    		// initialize calendar
    	 	Calendar calendar = Calendar.getInstance();
    	 	calendar.setTimeZone(TimeZone.getTimeZone("GMT"));
    	 	systemDate = calendar.getTime().toInstant().atZone(ZoneId.of("GMT")).toLocalDate();
    	 	
    	 	
    	 	Role ROLE_ADMIN = RoleRepo.save(new Role(ADMIN,"ADMIN"));
    	 	Role ROLE_USER = RoleRepo.save(new Role(USER,"USER"));
    	 	Role ROLE_PREMIUM = RoleRepo.save(new Role(PREMIUM,"PREMIUM"));
    					
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
    		
    }

