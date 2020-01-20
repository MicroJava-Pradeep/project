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
import org.springframework.web.bind.annotation.RestController;

import com.app.model.OrderMethod;
import com.app.service.IOrderMethodService;

@RestController
@RequestMapping("/rest/om")
public class OrderMethodRestController {

	@Autowired
	private IOrderMethodService service;

	@GetMapping("/all")
	public ResponseEntity<?> get() {
		ResponseEntity<?> message = null;
		List<OrderMethod> oms = service.getAllOrderMethod();
		if (oms == null || oms.isEmpty()) {
			message = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			message = new ResponseEntity<List<OrderMethod>>(oms, HttpStatus.OK);

		}
		return message;
	}

	@GetMapping("/one/{id}")
	public ResponseEntity<?> getOne(@PathVariable Integer id) {

		ResponseEntity<?> message = null;
		OrderMethod oms = service.getoneOrderMethod(id);
		if (oms == null) {
			message = new ResponseEntity<OrderMethod>(HttpStatus.NO_CONTENT);
		} else {
			message = new ResponseEntity<OrderMethod>(oms, HttpStatus.OK);
		}
		return message;
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable Integer id) {
		ResponseEntity<String> message = null;
		try {
			service.deleteOrderMethod(id);
			;
			message = new ResponseEntity<String>("deleted successfully", HttpStatus.OK);
		} catch (Exception e) {
			message = new ResponseEntity<String>("No Content Found", HttpStatus.BAD_REQUEST);
		}

		return message;
	}

	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody OrderMethod OrderMethod) {

		ResponseEntity<String> message = null;
		try {
			Integer id = service.saveOrderMethod(OrderMethod);
			message = new ResponseEntity<>("OrderMethod '" + id + "' is saved", HttpStatus.OK);
		} catch (Exception e) {
			message = new ResponseEntity<>("OrderMethod is not saved", HttpStatus.BAD_REQUEST);

		}
		return message;
	}

	@PutMapping("/update")
	public ResponseEntity<String> update(@RequestBody OrderMethod OrderMethod) {
		ResponseEntity<String> message = null;
		try {
			service.updateOrderMethod(OrderMethod);
			message = new ResponseEntity<String>("OrderMethod is updated", HttpStatus.OK);
		} catch (Exception e) {

			message = new ResponseEntity<String>("OrderMethod is not updated", HttpStatus.BAD_REQUEST);
		}
		return message;
	}
}
