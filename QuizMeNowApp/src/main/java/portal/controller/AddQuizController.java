package portal.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import portal.domain.QuizOrganizer;
import portal.domain.QuizUser;
import portal.domain.Quiz;
import portal.repository.QuizRepository;
import portal.repository.UserRepository;
//All the following actions take place on https://localhost:8090/
@Controller
@RequestMapping("/")
public class AddQuizController {

	@Autowired
	private UserRepository userRepo;
	@Autowired
	private QuizRepository quizRepo;
	//Apply QuizValidators for the quiz additions
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(new QuizValidator());
	}
    //Navigating from the main menu to the create quiz webpage
	@RequestMapping(value = "create", method = RequestMethod.GET)
	public String create(Model model) {
		model.addAttribute("quiz", new Quiz());
		return "CreateQuiz";
	}
    //adding a quiz to the database
	@RequestMapping(value = "create", params = "add", method = RequestMethod.POST)
	public String addNewQuiz(@Valid @ModelAttribute("quiz") Quiz t, BindingResult result, Model model, Principal principal) {
		//Re show the create quiz page if there are any errors
		if (result.hasErrors()) {
			return "CreateQuiz";
		} else {
			QuizUser user = userRepo.findByLogin(principal.getName());
			// add organizer if the user doesn't already have one
			if (user.getOrganizers().isEmpty()) {
				QuizOrganizer o = new QuizOrganizer();
				user.getOrganizers().add(o);
				o.setOwner(user);
			}
			//add and save the quiz to the quizs database then redirect to the main menu
			user.getOrganizers().get(0).addQuiz(t);
			userRepo.save(user);
			return "redirect:/mainMenu";
		}
	}
	//If the cancel button is pressed abort create quiz and return to main menu
	@RequestMapping(value = "create", params = "cancel", method = RequestMethod.POST)
	public String cancelNewQuiz() {
		return "redirect:/mainMenu";
	}
	//deleting row in the list of quizzes table 
	@RequestMapping(value = "delete", params = "id", method = RequestMethod.GET)
	public String deleteQuiz(@RequestParam("id") int id, Principal principal) {
		Quiz t = quizRepo.findById(id);		
		// if the quiz database isn't empty then perform removal
		if (t != null) {
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
		//update the list of quizzes
		return "redirect:/list";
	}
}