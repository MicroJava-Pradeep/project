package com.app.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.app.model.ShipmentType;
@Component
public class ShipmentTypeValidation implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return ShipmentType.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ShipmentType ship=(ShipmentType)target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mode", null, "Please choose one option");
		if (ship.getCode()==null||ship.getCode().isEmpty()) {
			errors.rejectValue("code", null, "Please enter valid data");
		}
		if (ship.getEnabled()==null||ship.getEnabled().isEmpty()) {
			errors.rejectValue("enabled", null, "Please enter valid data");
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "grade",null, "Please choose one option");
		
		if (ship.getDsc()==null||ship.getDsc().length()<10||ship.getDsc().length()>30) {
			errors.rejectValue("dsc", null, "Please enter Desription between 10 to 30 Character");
		}
	}

}
