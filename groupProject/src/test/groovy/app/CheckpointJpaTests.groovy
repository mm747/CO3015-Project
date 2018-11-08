package app;

import static org.hamcrest.CoreMatchers.*
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException

import portal.repository.RoleRepository;
import portal.repository.StatusRepository
import portal.repository.UserInfoRepository;
import portal.DbConfig;
import portal.PortalApp;
import portal.domain.Role
import portal.domain.Status
import portal.domain.UserInfo
import spock.lang.Specification;

@DataJpaTest
@SpringBootTest(classes=[PortalApp.class,DbConfig.class])
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class CheckpointJpaTests extends Specification {
	@Autowired
	private RoleRepository roleRepo;
	@Autowired
	private UserInfoRepository userRepo;
	@Autowired
	private StatusRepository statusRepo;
	
	def setup() {
		userRepo.deleteAll()
		roleRepo.deleteAll()
	}
	
	def "INSTANCE. product"() {
		given:
			Status p = new Status()
			p.setName("James")
			p.setDescription("James")
			Status managedObject = statusRepo.save(p)
		when:
			Status p2 = statusRepo.findById(managedObject.getId())
		then:
			assertThat("", p2, hasProperty("name", equalTo(p.getName())));
	}
	
	def "NNV. product with no name"() {
		given:
			Status p = new Status()
			p.setDescription("teacher")
			Status managedObject = statusRepo.save(p)
		when:
			Status p2 = statusRepo.findById(managedObject.getId())
		then:
			thrown(DataIntegrityViolationException)
	}
	
	
	
	
	
	def "INSTANCE. role"() {
		given:
			def o = new Role()
			o.setId(4)
			o.setRole("User")
			def managedObject = roleRepo.save(o)
		when:
			def o2 = roleRepo.findByRole("User")
		then:
			assertThat("", o2, hasProperty("role", equalTo(o.getRole())));
	}
	def "NNV. role with no name"() {
		given:
			def o = new Role()
			o.setId(4)
			def managedObject = roleRepo.save(o)
		when:
			def o2 = roleRepo.findById(4)
		then:
			thrown(DataIntegrityViolationException)
	}
	def "INSTANCE. userInfo"() {
		given:
			def o = new UserInfo()
			o.setForenames("David")
			o.setLastnames("Bowie")
			o.setUsername("d.bowie")
			o.setPassword("d.bowie")
			o.setPassword2("d.bowie")
			o.setEnabled(1)
			def managedObject = userRepo.save(o)
		when:
			def o2 = userRepo.findById(managedObject.getId())
		then:
			assertThat("", o2, hasProperty("username", equalTo(o.getUsername())));
	}
	def "NNV. userInfo with no login"() {
		given:
			def o = new UserInfo()
			o.setForenames("David")
			o.setLastnames("Bowie")
//			o.setLogin("d.bowie")
			o.setPassword("d.bowie")
			o.setPassword2("d.bowie")
			o.setEnabled(1)
			def managedObject = userRepo.save(o)
		when:
			def o2 = userRepo.findById(managedObject.getId())
		then	:
			thrown(DataIntegrityViolationException)
	}
	def "NNV. userInfo with no password"() {
		given:
			def o = new UserInfo()
			o.setForenames("David")
			o.setLastnames("Bowie")
			o.setUsername("d.bowie")
//			o.setPassword("d.bowie")
			o.setPassword2("d.bowie")
			o.setEnabled(1)
			def managedObject = userRepo.save(o)
		when:
			def o2 = userRepo.findById(managedObject.getId())
		then	:
			thrown(DataIntegrityViolationException)
	}
	
	
	
}

