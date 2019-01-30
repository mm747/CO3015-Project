package portal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import portal.domain.OrganizerUser;
import portal.domain.Role;
import portal.repository.RoleRepository;
import portal.repository.UserRepository;

@SpringBootApplication
public class OrganizerApp implements CommandLineRunner  { 

	@Autowired
	private UserRepository userRepo;	
	@Autowired
	private RoleRepository roleRepo;
	
	public static void main(String[] args) {
        SpringApplication.run(OrganizerApp.class, args);
        
    }

	@Override
	public void run(String... args) throws Exception {
		
		// TODO Task XXX

		BCryptPasswordEncoder pe = new  BCryptPasswordEncoder();

		OrganizerUser user = new OrganizerUser();
		user.setLogin("admin");
		user.setPassword(pe.encode("admin"));
		portal.domain.Role role = new Role();
		role.setId(0);
		role.setRole("ADMIN");
		roleRepo.save(role);
		
		user.setRole(role);
		userRepo.save(user);
		
		role = new Role();
		role.setRole("MANAGER");
		role.setId(1);
		roleRepo.save(role);
		
		role = new Role();
		role.setRole("ASSISTANT");
		role.setId(2);
		roleRepo.save(role);
	}
}
