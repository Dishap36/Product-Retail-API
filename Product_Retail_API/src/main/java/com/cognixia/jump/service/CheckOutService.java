package com.cognixia.jump.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognixia.jump.exception.ResourceNotFoundException;
import com.cognixia.jump.model.CheckOut;
import com.cognixia.jump.model.CustomerOrder;
import com.cognixia.jump.model.Product;
import com.cognixia.jump.repository.CheckOutRepository;
import com.cognixia.jump.repository.CustomerOrderRepository;
import com.cognixia.jump.repository.ProductRepository;

@Service

public class CheckOutService {

	@Autowired
	CheckOutRepository repo;
	
	@Autowired
	ProductRepository prodRepo;
	
	
    @Autowired
    CustomerOrderRepository custodrrepo;
	
	
	public Product getProductByName (String name) throws ResourceNotFoundException {
		
		Optional<Product> found = prodRepo.findById(name);
		
		if(found.isPresent() ) {
		
		return found.get();
		}
		 throw new ResourceNotFoundException("Product name not found");
	}
	
	
	
	
	
	public CustomerOrder getCustomerOrderName (String name) throws ResourceNotFoundException {
		
		Optional<CustomerOrder> found = custodrrepo.findById(name);
		
		if(found.isPresent() ) {
			
			return found.get();
			}
			 throw new ResourceNotFoundException("Item not found");
		}
		
		
		}
		
	
	
	
	
	


