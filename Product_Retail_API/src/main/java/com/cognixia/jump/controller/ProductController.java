package com.cognixia.jump.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognixia.jump.exception.ResourceNotFoundException;
import com.cognixia.jump.model.Product;
import com.cognixia.jump.repository.ProductRepository;

@RequestMapping("/api")
@RestController
public class ProductController {
	
	@Autowired
	ProductRepository repo;
	
	@GetMapping("/product")
	public List<Product> getProducts() {
		return repo.findAll();
	}
	
	
	// to gell all products
	@GetMapping("/product/{ProdId}")
	public ResponseEntity<?> getProduct(@PathVariable String ProdId) throws ResourceNotFoundException {
		
		Optional<Product> found = repo.findById(ProdId);
		
		if(found.isEmpty()) {
			throw new ResourceNotFoundException("Product with id = " + ProdId + " was not found");
		}
		
		return ResponseEntity.status(200).body(found.get());
	}
	
	
	// to add a product
	@PostMapping("/product")
	public ResponseEntity<Product> createProduct(@RequestBody Product product) {
		
		product.setProdId(null);
		
		product.setOrganic(true);
		product.setPrepacked(true);
		
		Product created = repo.save(product);
		
		return ResponseEntity.status(201).body(created);
		
		
	}
	
	
	// to delete a product
	@DeleteMapping("/product/{ProdId}")
	public ResponseEntity<?> deleteProduct(@PathVariable String ProdId) throws ResourceNotFoundException {
		
		Optional<Product> found = repo.findById(ProdId);
		
		if( found.isEmpty() ) {
			
			throw new ResourceNotFoundException("Product with id = " + ProdId + " was not found");
		}
		
		repo.deleteById(ProdId);
		
		return ResponseEntity.status(200).body(found.get());
	}
	
}




