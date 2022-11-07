package com.cognixia.jump.model;


import javax.validation.constraints.Pattern;

public class CustomerOrder {

	@Pattern(regexp = "^[A-Z]{12}$", message = "Please enter a valid name")
	private String name;
	
	
	private String price;
	
	public CustomerOrder () {
		
	}


	


	public CustomerOrder(@Pattern(regexp = "^[A-Z]{12}$", message = "Please enter a valid name") String name,
			String price) {
		super();
		this.name = name;
		this.price = price;
	}





	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPrice() {
		return price;
	}





	public void setPrice(String price) {
		this.price = price;
	}





	@Override
	public String toString() {
		return "CustomerOrder [name=" + name + ", price=" + price + "]";
	}
	
	
}
