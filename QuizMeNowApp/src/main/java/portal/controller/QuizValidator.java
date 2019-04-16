package portal.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import portal.domain.Quiz;

public class QuizValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return Quiz.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Quiz t = (Quiz) target;
		//display message if fields entered are empty
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "QuizName", "", "Field cannot be empty.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "priority", "", "Field cannot be empty.");
		
		if (t.isImportant() && t.getDescription().isEmpty()) {
			errors.rejectValue("description", "", "Important quizs require a description.");
		} else if (!t.isImportant()) {
			if (t.getPriority() >= 100) {
				errors.rejectValue("priority", "", "If the Quiz is not important the priority must be below 100.");
			} else if (t.getDescription().length() > 20) {
				errors.rejectValue("description", "", "Quiz with low priority should have short descriptions.");
			}
		} else if (t.getDescription().equals(t.getquizName())) {
			errors.rejectValue("QuizName", "", "The QuizName cannot equal the descriptions.");
		}
	}

}