package com.cognixia.jump.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognixia.jump.model.CheckOut;
import com.cognixia.jump.repository.CheckOutRepository;

@RequestMapping("/api")
@RestController
public class CheckOutController {
	
	@Autowired
	CheckOutRepository repo;
	
	
	// Get all items in cart
	
	@GetMapping("/checkout")
	public List<CheckOut>getCheckOut() {
		return repo.findAll();
	}
	

	// add an item to cart
	
	@PostMapping("/")
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
