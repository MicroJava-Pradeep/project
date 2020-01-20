package com.app.validation;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.app.model.PurchaseOrder;
@Component
public class PurchaseOrderValidation implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return PurchaseOrder.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		PurchaseOrder po=(PurchaseOrder)target;
		if (!Pattern.compile("[A-Z]{4,10}").matcher(po.getOrderCode()).matches()) {
			errors.rejectValue("orderCode", null, "Please enter only 4-10 Upper case character only");
		}

		if (po.getShipmentCode()==null||po.getShipmentCode().getId()==null) {
			errors.rejectValue("shipmentCode", null, "Please select one shipment code");
		}
		if (po.getVendor()==null||po.getVendor().getId()==null) {
			errors.rejectValue("vendor", null, "Please select one vendor");
		}
		
		/*ValidationUtils.rejectIfEmptyOrWhitespace(errors, "shipmentCode", null, "Please select one shipment code");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "vendor", null,"Please select one vendor");
		*/
		if(!Pattern.compile("[A-Z0-9]{4}-[A-Z0-9]{4}-[A-Z0-9]{4}").matcher(po.getRefNum()).matches())
		{
			errors.rejectValue("refNum", null,"Please enter 4-4-4 combination of Upper and Digits");
		}
		if (po.getQualityCheck()==null||"".equals(po.getQualityCheck())) {
			errors.rejectValue("qualityCheck", null, "Please select one option");
		}
		if (!Pattern.compile("[A-Za-z0-9.\\s_\\t\\n]{10,200}").matcher(po.getPoDsc()).matches()) {
			errors.rejectValue("poDsc", null,"Please enter valide Description");
		}
		}

}
