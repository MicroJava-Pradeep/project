package com.app.validation;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.app.model.WhUserType;
@Component
public class WhUserTypeValidation implements Validator{
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return WhUserType.class.equals(clazz);
	}
	@Override
	public void validate(Object target, Errors errors) {
		
		WhUserType whUserType=(WhUserType)target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "type", null, "Please select one option");
		
		
		/*if ("".equals(whUserType.getType().trim())) {
			errors.rejectValue("type", null,"Please select one option");
		}*/
		if ("".equals(whUserType.getCode().trim())) {
			errors.rejectValue("code", null,"Please enter code value");
		}
		if ("".equals(whUserType.getForType().trim())) {
			errors.rejectValue("forType", null,"Please enter forType ");
		}
		if(!Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE).matcher(whUserType.getEmail()).matches()){
			errors.rejectValue("email",null,"Please enter valid email !!!!");
		}
		
		if (!Pattern.compile("[789]{1}\\d{9}").matcher(whUserType.getContact()).matches()) {
			errors.rejectValue("contact", null,"Please enter valid contact");
		}
		if ("".equals(whUserType.getIdType().trim())) {
			errors.rejectValue("idType", null,"Please select one option");
		}
		if ("".equals(whUserType.getIdNum().trim())) {
			errors.rejectValue("idNum", null,"Please enter IdNum");
		}
		
		
	}
}
