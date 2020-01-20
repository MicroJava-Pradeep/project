package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateOptimisticLockingFailureException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.model.ShipmentType;
import com.app.service.IShipmentTypeService;
import com.app.validation.ShipmentTypeValidation;
import com.app.view.ShipmentTypeExcelView;
import com.app.view.ShipmentTypePdfView;

@Controller
@RequestMapping("/shipmenttype")
public class ShipmentTypeController {

	@Autowired
	private IShipmentTypeService service;
	
	@Autowired
	private ShipmentTypeValidation valid1;
	
	@RequestMapping("/show")
	public String showShipmentPage(ModelMap map)
	{
		map.addAttribute("shipmentType", new ShipmentType());
		return "ShipmentTypeRegister";
	}
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String saveShipmentData(@ModelAttribute("shipmentType")ShipmentType stype,Errors errors,ModelMap map)
	{
		valid1.validate(stype, errors);
		if(!errors.hasErrors())
		{
		Integer sid=service.saveShipmentType(stype);
		String msg="Shipment '"+sid+"' Saved";
		map.addAttribute("message", msg);
		map.addAttribute("shipmentType", new ShipmentType());
		}
		else
		{
			map.addAttribute("message","Enter all data");
			
		}
		return "ShipmentTypeRegister";

	}
	
	@RequestMapping("/data")
	public String showData(ModelMap map) {
		List<ShipmentType> emps = service.getAllShipmentTypes();
		map.addAttribute("list", emps);
		return "ShipmentTypeData";
	}
	
	// Delete 
		@RequestMapping("/delete")
		public String deleteShipmentType(@RequestParam("id") Integer sId, ModelMap map) {
			String message=null;
			try{
				service.deleteShipmentType(sId);;
				message = "Employee Id'" + sId + "' Deleted";
				
			}catch(HibernateOptimisticLockingFailureException e){
				message = "Employee Id'" + sId + "' not Found";

			}
			List<ShipmentType> stype = service.getAllShipmentTypes();
			map.addAttribute("message", message);
			map.addAttribute("list", stype);
			return "ShipmentTypeData";
		}
		
		// Show Edit Page
		@RequestMapping("/edit")
		public String showEdit(@RequestParam("id") Integer sId, ModelMap map) {
			ShipmentType stype = service.getOneShipmentType(sId);
			map.addAttribute("shipmentType", stype);

			return "ShipmentTypeEdit";
		}

		// Update Employee
		@RequestMapping(value="/update",method=RequestMethod.POST)
		public String updateShipmentType(@ModelAttribute ShipmentType stype,Errors errors,ModelMap map)  {
			valid1.validate(stype, errors);
			if(!errors.hasErrors())
			{
			service.updateShipmentType(stype);
			String msg="Employee '"+stype.getId()+"' Updated Successfully";
			List<ShipmentType> stypes=service.getAllShipmentTypes();
			map.addAttribute("message", msg);
			map.addAttribute("list", stypes);
			return "ShipmentTypeData";
			}
			else{
				map.addAttribute("message","Please enter all details");
				return "ShipmentTypeEdit";
			}
		}
	
		@RequestMapping("/excel")
		public ModelAndView exportExcel()
		{
			List<ShipmentType> sTypes=service.getAllShipmentTypes();
			
			ModelAndView mav=new ModelAndView();
			
			mav.addObject("sType", sTypes);
			mav.setView(new ShipmentTypeExcelView());
			return mav;
		}
		@RequestMapping("/pdf")
		public ModelAndView exportPdf()
		{
			List<ShipmentType> sTypes=service.getAllShipmentTypes();
			
			ModelAndView mav=new ModelAndView();
			mav.addObject("sType", sTypes);
			mav.setView(new ShipmentTypePdfView());
			return mav;
		}
}
