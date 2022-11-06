package com.cognixia.jump.model;


import javax.validation.constraints.Pattern;

public class CustomerOrder {

	@Pattern(regexp = "^[A-Z]{12}$", message = "Please enter a valid name")
	private String name;
	
	
	public CustomerOrder () {
		
	}


	public CustomerOrder(@Pattern(regexp = "^[A-Z]{12}$", message = "Please enter a valid name") String name) {
		super();
		this.name = name;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "CustomerOrder [name=" + name + "]";
	}
	
	
}
