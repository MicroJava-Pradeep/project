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

import com.app.model.Uom;
import com.app.service.IUomService;
import com.app.validation.UomValidation;
import com.app.view.UomExcelView;
import com.app.view.UomPdfView;

@Controller
@RequestMapping("/uom")
public class UomController {

	@Autowired
	private IUomService service;
	@Autowired
	private UomValidation validate;

	@RequestMapping("/register")
	public String showUomPage(ModelMap map) {
		
		map.addAttribute("uomtype", new Uom());
		
		return "UomRegister";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveUomData(@ModelAttribute("uomtype") Uom uom,Errors errors, ModelMap map) {
		validate.validate(uom, errors);
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		if(!errors.hasErrors()){
		Integer uid = service.saveUom(uom);
		String msg = "Uom '" + uid + "' Saved";
		map.addAttribute("message", msg);
		//map.addAttribute("uomtype", new Uom());
		}
		else{
			map.addAttribute("msg","Please fill all the fields");
		}
		return "UomRegister";
	}

	@RequestMapping("/data")
	public String showData(ModelMap map) {
		List<Uom> uoms = service.getAllUom();
		map.addAttribute("list", uoms);
		return "UomData";
	}

	// Delete
	@RequestMapping("/delete")
	public String deleteUom(@RequestParam("id") Integer uId, ModelMap map) {
		
//============================================================================
		
		String message=null;
		try{
			if (service.isUomConnectedWithItem(uId)) {
				message="You can not be deleted";
			}
			else{
				service.deleteUom(uId);
				message="Uom '"+uId+"'deleted Successfully";
				
			}
		}catch (HibernateOptimisticLockingFailureException e) {
			message="Uom  '"+uId+"' not found";
		}
//============================================================================
		/*String message=null;
		try{
			service.deleteUom(uId);
			message="Uom '" + uId + "' Deleted  successfully";
		}catch(HibernateOptimisticLockingFailureException e){
			message="'"+uId+"'  id not found";
		}
		 */
		
		List<Uom> uom = service.getAllUom();
		map.addAttribute("message", message);
		map.addAttribute("list", uom);
		
		return "UomData";
	}

	// Show Edit Page
	@RequestMapping("/edit")
	public String showEdit(@RequestParam("id") Integer uId, ModelMap map) {
		Uom uom = service.getoneUom(uId);
		map.addAttribute("uomtype", uom);

		return "UomEdit";
	}

	// Update Employee
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateUom(@ModelAttribute("uomtype")Uom uomtype,Errors errors,ModelMap map) {
		validate.validate(uomtype, errors);
		if(!errors.hasErrors()){		
		service.updateUom(uomtype);		
		String msg = "Uom '" + uomtype.getId() + "' Updated Successfully";
		List<Uom> uoms = service.getAllUom();
		map.addAttribute("message", msg);
		map.addAttribute("list", uoms);
		return "UomData";
		}
		else
		
			map.addAttribute("message","Please enter all the details");
			return "UomEdit";
	}
	
	@RequestMapping("/excel")
	public ModelAndView showExcelFormat() {
		//get All employee details
		List<Uom> uoms=service.getAllUom();
		System.out.println("Uom Data...."+uoms);
		//to render data on Excel format we need to create ModelAndView object
		ModelAndView mav=new ModelAndView();
		//add data to model
		mav.addObject("uoms", uoms);
		//set view to render data
		mav.setView(new UomExcelView());
		return mav;
	}//showExcelFormat()
	
	//8.0 Export data to pdf format
		@RequestMapping("/pdf")
		public ModelAndView showPdf() {
			//fetch data from db
		 	List<Uom> uoms=service.getAllUom();
			//create ModelAndView object
			ModelAndView mav=new ModelAndView();
			mav.setView(new UomPdfView());
			mav.addObject("uoms", uoms);
			return mav;
		}//showPdf()

}
