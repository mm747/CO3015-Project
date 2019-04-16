package portal.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import portal.domain.QuizOrganizer;
import portal.domain.QuizUser;
import portal.domain.Quiz;
import portal.repository.QuizRepository;
import portal.repository.UserRepository;
//All the following actions take place on https://localhost:8090/
@Controller
@RequestMapping("/")
public class QuizMenuController {

	@Autowired
	UserRepository userRepo;

	@Autowired
	QuizRepository quizRepo;

	@RequestMapping("/")
	public String start() {
		return "redirect:/mainMenu";
	}
	//View the list of quizzes
	@RequestMapping("/list")
	public String listOfQuiz(Model model, Principal principal) {


		QuizUser user = userRepo.findByLogin(principal.getName());
		
		List<Quiz> quizs = new ArrayList<>();
		addQuizsForUser(quizs, user);
		//if quizs database is empty return mainmenu
		if (quizs.isEmpty()) {
			return "redirect:/mainMenu";
		} else {
			model.addAttribute("quizs", quizs);
		}
		return "ListOfQuiz";
	}

	private void addQuizsForUser(List<Quiz> quizs, QuizUser user) {
		if ("TEACHER".equals(user.getRole().getRole())) {
			// add quizs of the teacher 
			for (QuizOrganizer o : user.getOrganizers()) {
				quizs.addAll(o.getQuizs());
			}
		} else if ("USER".equals(user.getRole().getRole())) {
			// add all quizs in the system
			for (Quiz t : quizRepo.findAll()) {
				quizs.add(t);
			}
		}
	}

	@RequestMapping(value = "/mainMenu", method = RequestMethod.GET)
	public String next(Model model, Principal principal) {
			return "MainMenu";
	}

}