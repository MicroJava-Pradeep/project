package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.model.PurchaseOrder;
import com.app.model.ShipmentType;
import com.app.model.WhUserType;
import com.app.service.IPurchaseOrderService;
import com.app.service.IShipmentTypeService;
import com.app.service.IWhUserTypeService;
import com.app.validation.PurchaseOrderValidation;

@Controller
@RequestMapping("/po")
public class PurchaseOrderController {

	@Autowired
	private IPurchaseOrderService service;

	@Autowired
	private IShipmentTypeService shipService;

	@Autowired
	private IWhUserTypeService whService;

	@Autowired
	private PurchaseOrderValidation valid;

	@RequestMapping("/show")
	public String show(ModelMap map) {
		List<ShipmentType> stype = shipService.getShipmentTypeByEnbled("yes");
		map.addAttribute("ship", stype);
		System.out.println("********" + stype);

		List<WhUserType> ven = whService.getWhUserTypesByUserTypes("vendor");
		map.addAttribute("whuser", ven);
		System.out.println("********" + ven);

		map.addAttribute("purchaseOrder", new PurchaseOrder());
		return "PurchaseOrderRegistration";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String save(@ModelAttribute("purchaseOrder") PurchaseOrder porder, Errors errors, ModelMap map) {

		valid.validate(porder, errors);
		List<WhUserType> ven = whService.getWhUserTypesByUserTypes("vendor");
		map.addAttribute("whuser", ven);
		
		map.addAttribute("msg", "Data saved successfully");
		List<ShipmentType> stype = shipService.getShipmentTypeByEnbled("yes");
		map.addAttribute("ship", stype);
		
		if (!errors.hasErrors()) {			

			
			service.savePurchaseOrder(porder);
			map.addAttribute("purchaseOrder", new PurchaseOrder());
			String msgg = "data savad";
			map.addAttribute("msg", msgg);

			
		} else {
			map.addAttribute("msg", "Enter valid data");
		}
		return "PurchaseOrderRegistration";

	}

	public String delete() {

		return null;
	}
}
