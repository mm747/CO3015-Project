package portal.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import portal.domain.Quiz;
import portal.domain.QuizOrganizer;
import portal.domain.QuizUser;
import portal.repository.QuizRepository;
import portal.repository.RoleRepository;
import portal.repository.UserRepository;
//All the following actions take place on https://localhost:8090/admin/
@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	RoleRepository roleRepo;
	@Autowired
	QuizRepository quizRepo;
	@Autowired
	UserRepository userRepo;
	//Apply QuizUserValidators for the registration entries
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(new QuizUserValidator(userRepo));
	}
	
    //navigate to admin main menu
	@RequestMapping(value = "/mainMenu", method = RequestMethod.GET)
	public String next(Model model, Principal principal) {
			return "admin/AdminMainMenu";
	}
    //navigate to create user	
	@RequestMapping(value = "/createUser", method = RequestMethod.GET)
	public String create(Model model, String roleName) {
		model.addAttribute("orgUser", new QuizUser());
		return "admin/CreateUser";
	}
    //click on add user
	@RequestMapping(value = "/createUser", params = "add", method = RequestMethod.POST)
	public String addNewUser(@RequestParam("roleName") String roleName, @Valid @ModelAttribute("orgUser") QuizUser u, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "admin/CreateUser";
		} else {
			//Encrypts the password registered with
			BCryptPasswordEncoder pe = new  BCryptPasswordEncoder();			
			u.setPassword(pe.encode(u.getPassword()));
			u.setRole(roleRepo.findByRole(roleName));
			//stores the entry onto QuizUser database as a new user
			userRepo.save(u);
			
			return "admin/AdminMainMenu";
		}
	}
//click on cancel and return to admin main menu
	@RequestMapping(value = "/createUser", params = "cancel", method = RequestMethod.POST)
	public String cancelNewUser() {
		return "admin/AdminMainMenu";
	}
//view listofusers 	
	@RequestMapping(value="/userList",method = RequestMethod.GET)
	public String listOfUser(Model model, Principal principal) {

		model.addAttribute("orgUser", new QuizUser());
		QuizUser user = userRepo.findByLogin(principal.getName());
		//retrieving the row entries in order as how they are stored in the database.
		List<QuizUser> users = new ArrayList<>();
		displayUser(users, user);
		//when users database is empty return admin main menu
		if (users.isEmpty()) {
			return "admin/AdminMainMenu";
		} else {
			//retrieving the data from users table and storing as the list of users
			model.addAttribute("users", users);
		}
		return "admin/ListOfUsers";
	}
		
	@RequestMapping(value = "/searchedUser", params = "Search", method = RequestMethod.POST)
	public String addNewerUser(@Valid @ModelAttribute("orgUser") QuizUser u, BindingResult result, Model model) {
		if (userRepo.findByFname(u.getFname()) == null) {
			return "admin/ListOfUsers";
		} 
		else {
			
			return "admin/SearchedUser";
	}
		}	
	private void displayUser(List<QuizUser> users, QuizUser user) {
			// add users from all organizers
			for (QuizUser t : userRepo.findAll()) {
				users.add(t);
			}
		
		}
	
	@RequestMapping(value="/searchedUser",method = RequestMethod.GET)
	public String searchedUser(Model model, Principal principal) {

		model.addAttribute("orgUser", new QuizUser());
		QuizUser user = userRepo.findByFname(principal.getName());
		//retrieving the row entries in order as how they are stored in the database.
		List<QuizUser> users = new ArrayList<>();
		displaysearchedUser(users, user);
			//retrieving the data from users table and storing as the list of users
		model.addAttribute("users", users);
		return "admin/SearchedUser";
	}
	private void displaysearchedUser(List<QuizUser> users, QuizUser user) {
		// add users from all organizers
		for (QuizUser t : userRepo.findAll()) {
			users.add(t);
		}
	
	}
		
	
	//navigate to create user from the list of users page
	@RequestMapping(value = "userList/createUser", method = RequestMethod.GET)
	public String creater(Model model, String roleName) {
		model.addAttribute("orgUser", new QuizUser());
		return "admin/CreateUser";
	}

	//deleting the user along with everything they have ever added if they are a teacher
	@RequestMapping(value = "delete", params = "id", method = RequestMethod.GET)
	public String deleteUser(@RequestParam("id") int id, Principal principal) {
		Quiz t = quizRepo.findById(id);		
		// if the quiz database isn't empty then perform removal
		while (t != null) {
			// deleting the quiz will fail a foreign key constraint
			QuizUser user = userRepo.findByLogin(principal.getName());
			for (QuizOrganizer o : user.getOrganizers()) {
				if (o.getQuizs().contains(t)) {
					o.deleteQuiz(t.getId());					
				}
			}
	
			// delete quiz as orphan(single row)
			userRepo.save(user);
		}
		return "redirect:/admin/ListOfUsers";
	}
}
