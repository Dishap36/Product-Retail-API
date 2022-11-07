package com.cognixia.jump.model;

import java.time.LocalDate;
import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraintvalidation.SupportedValidationTarget;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document

public class Product {

	
//	 	"prodId": "1",
//	    "category": "Vegetables",
//	    "productname": "Spinach",
//	    "price": 2.00,
//	    "expiration date": "11-13-2022",
//	    "Organic": "true",
//	    "pre-packed": "true"
//	
//	
	@Id
	private String prodId;
	
	@NotBlank
	private String category;
	
	@NotBlank
	private  String productname;
	
	@NotBlank
	private double price;
	
	private LocalDate expiration;
	
	@NotBlank
	private boolean organic;
	
	@NotBlank
	private boolean prepacked;
	
	public Product() {
		
	}

	public Product(String prodId, @NotBlank String category, @NotBlank String productname, @NotBlank double price,
			LocalDate expiration, @NotBlank boolean organic, @NotBlank boolean prepacked) {
		super();
		this.prodId = prodId;
		this.category = category;
		this.productname = productname;
		this.price = price;
		this.expiration = expiration;
		this.organic = organic;
		this.prepacked = prepacked;
	}

	public String getProdId() {
		return prodId;
	}

	public void setProdId(String prodId) {
		this.prodId = prodId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public LocalDate getExpiration() {
		return expiration;
	}

	public void setExpiration(LocalDate expiration) {
		this.expiration = expiration;
	}

	public boolean isOrganic() {
		return organic;
	}

	public void setOrganic(boolean organic) {
		this.organic = true;
	}

	public boolean isPrepacked() {
		return prepacked;
	}

	public void setPrepacked(boolean prepacked) {
		this.prepacked = prepacked;
	}

	@Override
	public String toString() {
		return "Product [prodId=" + prodId + ", category=" + category + ", productname=" + productname + ", price="
				+ price + ", expiration=" + expiration + ", organic=" + organic + ", prepacked=" + prepacked + "]";
	}
	
	
	
	
	
	
	
	
	
}
