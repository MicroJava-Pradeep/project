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
import org.springframework.web.servlet.ModelAndView;

import com.app.model.Item;
import com.app.model.OrderMethod;
import com.app.model.Uom;
import com.app.model.WhUserType;
import com.app.service.IItemService;
import com.app.service.IOrderMethodService;
import com.app.service.IUomService;
import com.app.service.IWhUserTypeService;
import com.app.validation.ItemValidation;
import com.app.view.ItemExcelView;
import com.app.view.ItemPdfView;

@Controller
@RequestMapping("/item")
public class ItemController {

	@Autowired
	private IItemService service;

	@Autowired
	private IUomService uomService;

	@Autowired
	private IOrderMethodService omService;
	
	@Autowired
	private IWhUserTypeService whUserTypesService;
	
	@Autowired
	private ItemValidation valid;

	@RequestMapping("/show")
	public String showItemRegPage(ModelMap map) {
		map.addAttribute("item", new Item());
		// Uom
		List<Uom> uoms = uomService.getAllUom();
		map.addAttribute("uoms", uoms);

		// OrderMethod
		List<OrderMethod> sales = omService.getOrderMethodsByMode("sale");
		map.addAttribute("Sales", sales);
		List<OrderMethod> purchases = omService.getOrderMethodsByMode("purchase");
		map.addAttribute("Purchases", purchases);
		
		//WhUserType
		List<WhUserType> vendors=whUserTypesService.getWhUserTypesByUserTypes("vendor");
		map.addAttribute("vendors", vendors);
		List<WhUserType> customers=whUserTypesService.getWhUserTypesByUserTypes("customer");
		map.addAttribute("customers", customers);
		return "ItemRegistration";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String saveItem(@ModelAttribute("item") Item item,Errors errors, ModelMap map) {
		
		valid.validate(item, errors);
		List<Uom> uoms = uomService.getAllUom();
		map.addAttribute("uoms", uoms);
		// OrderMethod
		List<OrderMethod> sales = omService.getOrderMethodsByMode("sale");
		map.addAttribute("Sales", sales);
		List<OrderMethod> purchases = omService.getOrderMethodsByMode("purchase");
		map.addAttribute("Purchases", purchases);
		
		//WhUserTYpe
		List<WhUserType> vendors=whUserTypesService.getWhUserTypesByUserTypes("vendor");
		
		map.addAttribute("vendors", vendors);
		List<WhUserType> customers=whUserTypesService.getWhUserTypesByUserTypes("customer");
		System.out.println("......custs......"+customers);
		map.addAttribute("customers", customers);
		
		if (!errors.hasErrors()) {
		
		Integer id = service.saveItem(item);		
		System.out.println("item data......"+item);
		String msg = "Item '" + id + "' Saved";
		map.addAttribute("message", msg);
		map.addAttribute("item", new Item());

		
		}else{
			
			map.addAttribute("message", "Plaese enter all data");
		}
		
		return "ItemRegistration";
	}

	@RequestMapping("/all")
	public String showItems(ModelMap map) {
		List<Item> items = service.getAllItems();
		map.addAttribute("items", items);
		return "ItemData";
	}

	@RequestMapping("/delete")
	public String deleteItem(@ModelAttribute("id") Integer id, ModelMap map) {
		String message=null;
		try{
			service.deleteItem(id);
			message="'"+id+"' id is deleted successfully";
		}catch(HibernateOptimisticLockingFailureException e){
			message="'"+id+"' id is not found";	
		}

		List<Item> items = service.getAllItems();

		map.addAttribute("message", message);
		map.addAttribute("items", items);
		return "ItemData";
	}

	@RequestMapping("/edit")
	public String showEditItemPage(@ModelAttribute("id") Integer id, ModelMap map) {
		Item item = service.getOneItem(id);
		map.addAttribute("item", item);
		List<Uom> uoms = uomService.getAllUom();
		map.addAttribute("uoms", uoms);

		// OrderMethod
		List<OrderMethod> sales = omService.getOrderMethodsByMode("sale");
		map.addAttribute("Sales", sales);
		List<OrderMethod> purchases = omService.getOrderMethodsByMode("purchase");
		map.addAttribute("Purchases", purchases);
		
		//WhUserType
		List<WhUserType> vendors=whUserTypesService.getWhUserTypesByUserTypes("vendor");
		map.addAttribute("vendors", vendors);
		List<WhUserType> customers=whUserTypesService.getWhUserTypesByUserTypes("customer");
		map.addAttribute("customers", customers);
		return "ItemEdit";
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(@ModelAttribute("item") Item item, Errors errors,ModelMap map) {
		valid.validate(item, errors);
		if (!errors.hasErrors()) {		
		service.updateItem(item);
		String msg = "Item '" + item.getId() + "' Updated";
		map.addAttribute("message", msg);
		List<Item> items = service.getAllItems();
		map.addAttribute("items", items);
		return "ItemData";
		}
		else{
			
			map.addAttribute("message","Please enter all fields");
			return "ItemEdit";
		}
			
	}

	@RequestMapping("/pdf")
	public ModelAndView exportItemsToPdf() {
		ModelAndView mav = new ModelAndView();

		List<Item> items = service.getAllItems();
		mav.addObject("items", items);
		mav.setView(new ItemPdfView());

		return mav;
	}

	@RequestMapping("/excel")
	public ModelAndView exportItemToExcel() {
		ModelAndView mav = new ModelAndView();

		List<Item> items = service.getAllItems();

		mav.addObject("items", items);
		mav.setView(new ItemExcelView());
		return mav;
	}

}
