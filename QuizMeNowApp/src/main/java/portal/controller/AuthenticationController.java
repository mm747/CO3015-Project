package portal.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import portal.domain.QuizUser;
import portal.repository.UserRepository;

@Controller
public class AuthenticationController {

	@Autowired
	UserRepository userRepo;

	@RequestMapping(value = "/user-login", method = RequestMethod.GET)
	public String loginForm() {
		return "security/login-form";
	}

	@RequestMapping(value = "/error-login", method = RequestMethod.GET)
	public String invalidLogin(Model model) {
		model.addAttribute("error", true);
		return "security/login-form";
	}

	/**
	 * Successful login is a redirect based on the role of the user
	 * 
	 * @param principal
	 * @return
	 */
	@RequestMapping(value = "/success-login", method = RequestMethod.GET)
	public String successLogin(Principal principal) {
		QuizUser user = userRepo.findByLogin(principal.getName());
		
		String view;
		switch (user.getRole().getRole()) {
		case "ADMIN":
			view = "redirect:/admin/mainMenu";
			break;
		default:
			view = "redirect:/mainMenu";
			break;
		}

		return view;
	}
	//logout of account returning back to the login form
	@RequestMapping(value = "/user-logout", method = RequestMethod.GET)
	public String logout(Model model) {
		model.addAttribute("logout", true);
		return "security/login-form";
	}
	//When user isn't given permission show error
	@RequestMapping(value = "/access-denied", method = RequestMethod.GET)
	public String error() {
		return "security/error-message";
	}
}