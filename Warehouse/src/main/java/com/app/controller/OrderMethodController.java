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

import com.app.model.OrderMethod;
import com.app.model.Uom;
import com.app.service.IOrderMethodService;
import com.app.validation.OrderMethodValidation;
import com.app.view.OrderMethodPdfView;
import com.app.view.OrderMethodXslView;
import com.app.view.UomExcelView;
import com.app.view.UomPdfView;

@Controller
@RequestMapping("/ordermethod")
public class OrderMethodController {
	@Autowired
	private IOrderMethodService service;
	
	@Autowired
	private OrderMethodValidation valid;

	@RequestMapping("/show")
	public String showOrderMethod(ModelMap map) {
		map.addAttribute("orderMethod", new OrderMethod());
		return "OrderMethodRegister";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveOrderMethodData(@ModelAttribute("orderMethod") OrderMethod order, Errors errors,ModelMap map) {
		valid.validate(order, errors);
		System.out.println("**************");
		if (!errors.hasErrors()) {
		Integer oId = service.saveOrderMethod(order);
		String msg = "OrderMethod '" + oId + "' Saved";
		map.addAttribute("message", msg);
		map.addAttribute("orderMethod", new OrderMethod());
		}
		else
		{
			map.addAttribute("message","Please provide all data");
		}
		return "OrderMethodRegister";
	}

	@RequestMapping("/data")
	public String showData(ModelMap map) {
	List<OrderMethod> orders = service.getAllOrderMethod();
		map.addAttribute("list", orders);
		return "OrderMethodData";
	}

	// Delete
	@RequestMapping("/delete")
	public String deleteOrderMethod(@RequestParam("id") Integer oId, ModelMap map) {
		String message=null;
		try{
			if (service.isOrderMethodConnectedWithItem(oId)) {
				message="you can not delete '"+oId+"'  Id ";	
			}
			else{
				
				service.deleteOrderMethod(oId);
				message="'"+oId+"'  Id deleted successfully";	
			}
		}catch(HibernateOptimisticLockingFailureException e){
			message="'"+oId+"' Id not found";

		}
		List<OrderMethod> oms = service.getAllOrderMethod();
		map.addAttribute("message", message);
		map.addAttribute("list", oms);
		return "OrderMethodData";
	}

	// Show Edit Page
	@RequestMapping("/edit")
	public String showEdit(@RequestParam("id") Integer oId, ModelMap map) {
		OrderMethod om = service.getoneOrderMethod(oId);
		map.addAttribute("orderMethod", om);

		return "OrderMethodEdit";
	}

	// Update Employee
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateOrderMethod(@ModelAttribute OrderMethod om, Errors errors,ModelMap map) {
		valid.validate(om, errors);
		if (!errors.hasErrors()) {
		service.updateOrderMethod(om);
		String msg = "Order Method  '" + om.getId() + "' Updated Successfully";
		List<OrderMethod> oms = service.getAllOrderMethod();
		map.addAttribute("msg", msg);
		map.addAttribute("list", oms);
		return "OrderMethodData";
		}else{
			
			map.addAttribute("msg", "Please provide all details");
			return "OrderMethodEdit";
		}
	}

	@RequestMapping("/excel")
	public ModelAndView showExcelFormat() {
		// get All employee details
		List<OrderMethod> oms = service.getAllOrderMethod();
		System.out.println("Uom Data...." + oms);
		// to render data on Excel format we need to create ModelAndView object
		ModelAndView mav = new ModelAndView();
		// add data to model
		mav.addObject("oms", oms);
		// set view to render data
		mav.setView(new OrderMethodXslView());
		return mav;
	}// showExcelFormat()

	// 8.0 Export data to pdf format
	@RequestMapping("/pdf")
	public ModelAndView showPdf() {
		// fetch data from db
		List<OrderMethod> oms = service.getAllOrderMethod();
		// create ModelAndView object
		ModelAndView mav = new ModelAndView();
		mav.setView(new OrderMethodPdfView());
		mav.addObject("oms", oms);
		return mav;
	}// showPdf()
}
