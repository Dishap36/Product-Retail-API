package com.cognixia.jump.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognixia.jump.model.CheckOut;
import com.cognixia.jump.model.CustomerOrder;
import com.cognixia.jump.repository.CheckOutRepository;
import com.cognixia.jump.repository.CustomerOrderRepository;
import com.cognixia.jump.repository.ProductRepository;
import com.cognixia.jump.service.CheckOutService;

@RestController
@RequestMapping("/api")
public class CheckOutController {
	
	@Autowired
	CheckOutRepository repo;
	
	
	@Autowired
	ProductRepository prodrepo;
	
	
	@Autowired
	CheckOutService cService;
	
	@Autowired
	CustomerOrderRepository custrepo;
	
	// Get all items in cart
	
	@GetMapping("/checkout")
	public List<CustomerOrder>getCheckOut() {
		return custrepo.findAll();
	}
	

	// add an item to cart
	
	@PostMapping("/checkout/add")
	public ResponseEntity<?> addItemToCart (@RequestBody CustomerOrder customerOrder) {
		
		if(prodrepo.findProductByProductname(customerOrder.getName()).size() == 0) {
			
			return ResponseEntity.status(400).body("Product does not exist");
			
		}
		
		if(prodrepo.existsById(prodrepo.findProductByProductname(customerOrder.getName()).get(0).getProdId())) {
			
			//double price = prodrepo.findProductByProductname(customerOrder.getName()).get(0).getPrice();
			
			CustomerOrder created = custrepo.save(customerOrder);
			
			return ResponseEntity.status(201).body(created);
		
		}
		return ResponseEntity.status(400).body("Product does not exist");
	}
	 
		
			
	
	
	
	
	
	
	
	
	
	
	
	
}
	

