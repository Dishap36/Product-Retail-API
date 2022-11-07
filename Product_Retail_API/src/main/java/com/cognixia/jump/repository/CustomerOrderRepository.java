package com.cognixia.jump.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cognixia.jump.model.CustomerOrder;

@Repository
public interface CustomerOrderRepository extends MongoRepository <CustomerOrder,String>{

	
}
