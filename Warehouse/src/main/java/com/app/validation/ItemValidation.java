package com.app.validation;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.app.model.Item;
@Component
public class ItemValidation implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Item.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		Item item = (Item) target;
		if (!Pattern.compile("[A-Z]{4,10}").matcher(item.getiCode()).matches()) {
			errors.rejectValue("iCode", null, "Please enter 4-10 Upper case Char");
		}
		

		if ("".equals(item.getWid()) || item.getWid() <= 0
				|| !Pattern.compile("[0-9]+[.]?[0-9]+").matcher(Double.toString(item.getWid())).matches()) {
			errors.rejectValue("wid", null, "Please enter valid width");
		}
		
		if ("".equals(item.getLen()) || item.getLen() <= 0
				|| !Pattern.compile("[0-9]+[.]?[0-9]+").matcher(Double.toString(item.getLen())).matches()) {
			errors.rejectValue("len", null, "Please enter valid lenght");
		}
		
		if ("".equals(item.getHgt()) || item.getHgt() <= 0
				|| !Pattern.compile("[0-9]+[.]?[0-9]+").matcher(Double.toString(item.getHgt())).matches()) {
			errors.rejectValue("hgt", null, "Please enter valid height");
		}
		
		/*if ("".equals(item.getBaseCost()) || item.getBaseCost() < 0
				|| !Pattern.compile("[0-9]+[.]?[0-9]+").matcher(Double.toString(item.getBaseCost())).matches()) {
			errors.rejectValue("baseCost", null, "Please enter valid value");
		}*/
		
		if ("".equals(item.getBaseCost()) || item.getBaseCost() <= 0
				|| !Pattern.compile("[0-9]+[.]?[0-9]+").matcher(Double.toString(item.getHgt())).matches()) {
			errors.rejectValue("baseCost", null, "Please enter valid cost");
		}		

		/*if (item.getBaseCurrency() == null || "".equals(item.getBaseCurrency())) {
			errors.rejectValue("baseCurrency", null, "Please select one Currency");
		}*/
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "baseCurrency", null,"Please select valid currency");
		

		/* Uom */

		/*if (item.getUom() == null || "".equals(item.getUom())) {
			errors.rejectValue("uom", null, "Please choose one uom value");
		}*/
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "uom.id", null,"Please select one uom	");
		
		/* Order Method */
		/*if (item.getSaleType() == null || "".equals(item.getSaleType())) {
			errors.rejectValue("saleType", null, "Please choose one value");
		}
		if (item.getPurchaseType() == null || "".equals(item.getPurchaseType())) {
			errors.rejectValue("purchaseType", null, "Please choose one value");
		}*/

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "saleType.id", null,"Please select one saleType	");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "purchaseType.id", null,"Please select one pusrches type	");
		/* WhUserType */
		if (item.getCustTypes() == null || item.getCustTypes().isEmpty()) {
			errors.rejectValue("custTypes", null, "Pleases select one value");
		}
		if (item.getVenTypes() == null || item.getVenTypes().isEmpty()) {
			errors.rejectValue("venTypes", null, "Pleases select one value");
		}
		/*--------*/

		if (!Pattern.compile("[A-Za-z0-9._\\t\\n\\s]{10,200}").matcher(item.getDsc()).matches()) {
			errors.rejectValue("dsc", null, "Please enter 4-10 Upper case Char");
		}

	}

}
