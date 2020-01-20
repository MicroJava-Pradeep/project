package com.app.validation;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.Uom;
import com.app.service.IUomService;
@Component
public class UomValidation implements Validator
{

	@Autowired
	private IUomService service;
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Uom.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		Uom uom=(Uom)target;
		if("".equals(uom.getUtype().trim())){
			errors.rejectValue("utype",null,"Please select one option!!!!");
		}
		
		if(!Pattern.compile("[A-za-z0-9]{4,10}").matcher(uom.getModel()).matches()){
			errors.rejectValue("model",null,"Please enter valid model (4 to 10 First letter Uppercase only) data!!!!");
		}else if(service.isUomModelExist(uom.getModel())){
			errors.rejectValue("model", null,"Uom model entry already Exist choose other");
		}
		
		if("".equals(uom.getDsc().trim())){
			errors.rejectValue("dsc",null,"Please enter description!!!!");
		}
	}
		
	}
