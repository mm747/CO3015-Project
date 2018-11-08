package portal.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import portal.domain.Status;


public class StatusValidator implements Validator {
		
	public boolean supports(Class<?> clazz) {
        return Status.class.equals(clazz);
    }

	@Override
	public void validate(Object target, Errors errors) {
		Status dto = (Status) target;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "", "Field cannot be empty.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "", "Field cannot be empty.");
		
	}
	
	
}
