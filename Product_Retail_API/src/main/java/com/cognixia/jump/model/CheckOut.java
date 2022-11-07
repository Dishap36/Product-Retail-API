package com.cognixia.jump.model;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class CheckOut {

	// res
		private String userId;
		// user id ;
		
		@Valid
		private List <CustomerOrder> customerorder;
		
		private double total;
		

		
		public CheckOut() {
			
			
		}

		public CheckOut(String userId, List<CustomerOrder> customerorder, double total) {
			super();
			this.userId = userId;
			this.customerorder = customerorder;
			this.total = total;
			
		}

		public String getUserId() {
			return userId;
		}

		public void setUserId(String userId) {
			this.userId = userId;
		}

		public List<CustomerOrder> getCustomerorder() {
			return customerorder;
		}

		public void setCustomerorder(List<CustomerOrder> customerorder) {
			this.customerorder = customerorder;
		}

		public double getTotal() {
			return total;
		}

		public void setTotal(double total) {
			this.total = total;
		}



		@Override
		public String toString() {
			return "CheckOut [userId=" + userId + ", customerorder=" + customerorder + ", total=" + total + "]";
		}
		
		
		
		
		
		
		
		
		
		
}
	
		
		
		

