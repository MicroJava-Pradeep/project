package com.app.validation;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.app.model.OrderMethod;
@Component
public class OrderMethodValidation implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return OrderMethod.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
			OrderMethod om=(OrderMethod)target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mode", null,"Please select one  option");
		if (!Pattern.compile("[A-Za-z-09]{4,8}").matcher(om.getCode()).matches()) {
			errors.rejectValue("code", null, "Please enter valid data");
		}
		if (!Pattern.compile("[A-Za-z-09]{4,8}").matcher(om.getMethod()).matches()) {
			errors.rejectValue("method", null, "Please enter valid data");
		}
		if (om.getAccept()==null||om.getAccept().isEmpty()) {
			errors.rejectValue("accept", null,"Please choose one option");
		}
		if (om.getDsc()==null||om.getDsc().length()<10||om.getDsc().length()>30) {
			errors.rejectValue("dsc",null,"Enter Description in 10 to 30 character");
		}
	}
}
