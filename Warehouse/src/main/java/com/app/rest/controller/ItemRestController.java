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

import com.app.model.Item;
import com.app.service.IItemService;
@RestController
@RequestMapping("/item/it")
public class ItemRestController {
/*
	@Autowired
	private IItemService service;

	@GetMapping("/all")
	public ResponseEntity<?> get() {
		ResponseEntity<?> message = null;
		//List<Item> oms = service.getAllItem();
		if (oms == null || oms.isEmpty()) {
			message = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			message = new ResponseEntity<List<Item>>(oms, HttpStatus.OK);

		}
		return message;
	}

	@GetMapping("/one/{id}")
	public ResponseEntity<?> getOne(@PathVariable Integer id) {

		ResponseEntity<?> message = null;
		Item oms = service.getoneItem(id);
		if (oms == null) {
			message = new ResponseEntity<Item>(HttpStatus.NO_CONTENT);
		} else {
			message = new ResponseEntity<Item>(oms, HttpStatus.OK);
		}
		return message;
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable Integer id) {
		ResponseEntity<String> message = null;
		try {
			service.deleteItem(id);
			;
			message = new ResponseEntity<String>("deleted successfully", HttpStatus.OK);
		} catch (Exception e) {
			message = new ResponseEntity<String>("No Content Found", HttpStatus.BAD_REQUEST);
		}

		return message;
	}

	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Item Item) {

		ResponseEntity<String> message = null;
		try {
			Integer id = service.saveItem(Item);
			message = new ResponseEntity<>("Item '" + id + "' is saved", HttpStatus.OK);
		} catch (Exception e) {
			message = new ResponseEntity<>("Item is not saved", HttpStatus.BAD_REQUEST);

		}
		return message;
	}

	@PutMapping("/update")
	public ResponseEntity<String> update(@RequestBody Item Item) {
		ResponseEntity<String> message = null;
		try {
			service.updateItem(Item);
			message = new ResponseEntity<String>("Item is updated", HttpStatus.OK);
		} catch (Exception e) {

			message = new ResponseEntity<String>("Item is not updated", HttpStatus.BAD_REQUEST);
		}
		return message;
	}
*/}
