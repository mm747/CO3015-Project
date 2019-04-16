package portal.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import portal.domain.QuizUser;
import portal.repository.UserRepository;

public class QuizUserValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return QuizUser.class.equals(clazz);
	}
	
	private UserRepository userRepo;
	
	public QuizUserValidator(UserRepository userRepo) {
		this.userRepo = userRepo;
	}

	@Override
	public void validate(Object target, Errors errors) {
		QuizUser u = (QuizUser) target;
		//display message if field entered is empty
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "", "Field cannot be empty.");
		//reject value and display message if the login entered is already in the database 
		if (userRepo.findByLogin(u.getLogin()) != null) {
			errors.rejectValue("login", "", "User with that username already exists.");
		}

	}

}
