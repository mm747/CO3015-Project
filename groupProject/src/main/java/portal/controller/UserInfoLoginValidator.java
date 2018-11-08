package portal.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import portal.domain.UserInfoLogin;

public class UserInfoLoginValidator implements Validator {
		
	public boolean supports(Class<?> clazz) {
        return UserInfoLogin.class.equals(clazz);
    }

	@Override
	public void validate(Object target, Errors errors) {
		UserInfoLogin dto = (UserInfoLogin) target;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "", "Field cannot be empty.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "", "Field cannot be empty.");
		
		if ((dto.getUsername()!=null) && (!dto.getUsername().equals("user"))) {
			errors.rejectValue("username", "", "User not registered.");
		}
		else if ((dto.getPassword() != null) && (!dto.getPassword().equals("password"))) {
			errors.rejectValue("password", "", "Password is not correct.");
		} 
	}
	
	
}
