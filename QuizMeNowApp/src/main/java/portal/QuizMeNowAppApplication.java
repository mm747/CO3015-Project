package portal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import portal.domain.QuizUser;
import portal.domain.Role;
import portal.repository.RoleRepository;
import portal.repository.UserRepository;

@SpringBootApplication
public class QuizMeNowAppApplication implements CommandLineRunner{

	@Autowired
	private UserRepository userRepo;	
	@Autowired
	private RoleRepository roleRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(QuizMeNowAppApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		

		BCryptPasswordEncoder pe = new  BCryptPasswordEncoder();

		QuizUser user = new QuizUser();
		user.setFname("admin");
		user.setSurname("admin");
		user.setLogin("admin");
		user.setPassword(pe.encode("admin"));
		portal.domain.Role role = new Role();
		role.setId(0);
		role.setRole("ADMIN");
		roleRepo.save(role);
		
		user.setRole(role);
		userRepo.save(user);
		
		role = new Role();
		role.setRole("TEACHER");
		role.setId(1);
		roleRepo.save(role);
		
		role = new Role();
		role.setRole("USER");
		role.setId(2);
		roleRepo.save(role);
	}
}
