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
import com.app.model.WhUserType;
import com.app.service.IWhUserTypeService;
import com.app.validation.WhUserTypeValidation;
import com.app.view.WhUserTypeExcelView;
import com.app.view.WhUserTypePdfView;

@Controller
@RequestMapping("/whusertype")
public class WhUserTypeController {

	@Autowired
	private IWhUserTypeService service;
	
	@Autowired
	private WhUserTypeValidation validate1;

	@RequestMapping("/show")
	public String showWhUserTypePage(ModelMap map) {
		map.addAttribute("whUserType", new WhUserType());
		return "WhUserTypeRegister";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveWhUserType(@ModelAttribute("whUserType") WhUserType user,Errors errors, ModelMap map) {
		validate1.validate(user, errors);
		if (!errors.hasErrors()) {	
		Integer whId = service.saveWhUserType(user);
		String msg = "WhUserType '" + whId + "' Saved";
		map.addAttribute("message", msg);
		map.addAttribute("whUserType", new WhUserType());
		}
		else{
			map.addAttribute("msg", "Please enter all details");
		}
		return "WhUserTypeRegister";
	}

	@RequestMapping("/all")
	public String showData(ModelMap map) {
		List<WhUserType> users = service.getAllWhUserType();
		map.addAttribute("list", users);
		return "WhUserTypeData";
	}

	// Delete
	@RequestMapping("/delete")
	public String deleteWhUser(@RequestParam("id") Integer whId, ModelMap map) {
		String message=null;
		try{
			if (service.isWhUserTypeConnectedWithItem(whId)) {
					message="id '"+whId+"' is connected with Item"	;
			}
			else{
			service.deleteWhUserType(whId);			
			message = "WhUsersType Id '" + whId + "' Deleted";
			}
		}catch(HibernateOptimisticLockingFailureException e){
			
			message = "WhUsersType Id '" + whId + "' not found";
		}
		List<WhUserType> users = service.getAllWhUserType();
		map.addAttribute("message", message);
		map.addAttribute("list", users);
		return "WhUserTypeData";
	}

	// Show Edit Page
	@RequestMapping("/edit")
	public String showEdit(@RequestParam("id") Integer whId, ModelMap map) {
		WhUserType user = service.getoneWhUserType(whId);
		map.addAttribute("whUserType", user);

		return "WhUserTypeEdit";
	}

	// Update Employee
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateWhUser(@ModelAttribute("")WhUserType whUserType,Errors errors ,ModelMap map) {
		validate1.validate(whUserType, errors);
		if (!errors.hasErrors()) {
		service.updateWhUserType(whUserType);
		String msg = "WhUser  '" + whUserType.getId() + "' Updated Successfully";
		List<WhUserType> users = service.getAllWhUserType();
		map.addAttribute("message", msg);
		map.addAttribute("list", users);
		return "WhUserTypeData";
		}
		else
		{
			map.addAttribute("message","Please provide all data");
			return "WhUserTypeEdit";
		}
	}
	
	
	//Excel Export
	@RequestMapping("/excel")
	public ModelAndView exportWhUserToExcel()
	{
		ModelAndView mav=new ModelAndView();
		List<WhUserType> whUsers=service.getAllWhUserType();
		
		mav.addObject("whUsers", whUsers);
		mav.setView(new WhUserTypeExcelView());
		return mav;
	}
	//Excel Export
		@RequestMapping("/pdf")
		public ModelAndView exportWhUserToPdf()
		{
			ModelAndView mav=new ModelAndView();
			List<WhUserType> whUsers=service.getAllWhUserType();
			
			mav.addObject("whUsers", whUsers);
			mav.setView(new WhUserTypePdfView());
			return mav;
		}
}
