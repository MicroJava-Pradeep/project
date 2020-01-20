package com.app.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Uom;
import com.app.service.IUomService;

@RestController
@RequestMapping("/rest/uom")
public class UomRestController {

	@Autowired
	private IUomService service;

	@GetMapping("/all")
	public ResponseEntity<?> get() {
		ResponseEntity<?> message = null;
		List<Uom> uoms = service.getAllUom();
		if (uoms == null || uoms.isEmpty()) {
			message = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			message = new ResponseEntity<List<Uom>>(uoms, HttpStatus.OK);

		}
		return message;
	}

	@GetMapping("/one/{id}")
	public ResponseEntity<?> getOne(@PathVariable Integer id) {

		ResponseEntity<?> message = null;
		Uom uoms = service.getoneUom(id);
		if (uoms == null) {
			message = new ResponseEntity<Uom>(HttpStatus.NO_CONTENT);
		} else {
			message = new ResponseEntity<Uom>(uoms, HttpStatus.OK);
		}
		return message;
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable Integer id) {
		ResponseEntity<String> message = null;
		try {
			service.deleteUom(id);
			message = new ResponseEntity<String>("deleted successfully", HttpStatus.OK);
		} catch (Exception e) {
			message = new ResponseEntity<String>("No Content Found", HttpStatus.BAD_REQUEST);
		}
		return message;
	}
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Uom uom){
		
		ResponseEntity<String> message=null;
		try{
				Integer id=service.saveUom(uom);
				message=new ResponseEntity<>("uom '"+id+"' is saved",HttpStatus.OK);
		}
		catch(Exception e){
			message=new ResponseEntity<>("Uom is not saved",HttpStatus.BAD_REQUEST);
			
		}
		return message;
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> update(@RequestBody Uom uom)
	{
		ResponseEntity<String> message=null;
		try{
			service.updateUom(uom);
			message=new ResponseEntity<String>("uom is updated",HttpStatus.OK);
		}
		catch(Exception e){
			
			message=new ResponseEntity<String>("uom is not updated",HttpStatus.BAD_REQUEST);
		}
		return message;
	}
}
