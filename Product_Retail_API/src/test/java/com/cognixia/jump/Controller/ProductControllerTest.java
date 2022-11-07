package com.cognixia.jump.Controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cognixia.jump.controller.ProductController;
import com.cognixia.jump.model.Product;
import com.cognixia.jump.repository.ProductRepository;

@WebMvcTest(ProductController.class)
public class ProductControllerTest {
	
	
	
	@InjectMocks
	ProductController controller;
	
	@MockBean
	ProductRepository prodrepo;
	
	
	@Autowired
	private MockMvc mockMvc;
	
	
	@Test
	public void testGetProducts() throws Exception {
		
		String uri = "/api/product";
		MvcResult mvcResult = mockMvc.perform(
				MockMvcRequestBuilders.get(uri)
				.accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
		
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		
				
	}

	@Test
	void testGetProducts2() throws Exception {
		
		List<Product> products = new ArrayList<Product>();
		products.add(new Product("Vegetables","1","Lime", 1.99, LocalDate.now(), true,true));
		
		String uri = "/api/product";
		
		when( controller.getProducts()).thenReturn( products);
		
		mockMvc.perform( get(uri) )
		.andDo( print() )
		.andExpect( status().isOk() )
		.andExpect( jsonPath("$.length()").value( products.size() ) ) // check size of resulting array
		.andExpect( jsonPath("$[0].prodId").value( products.get(0).getProdId() ) )
		.andExpect( jsonPath("$[1].productname").value( products.get(1).getProductname() ) )
		.andExpect( jsonPath("$[0].price").value( products.get(0).getPrice() ) )
		;
		
		verify(controller, times(1) ).getProducts(); //check this method is only called once
		//make sure no more methods from service are being called
		verifyNoMoreInteractions(controller);
		
		
		
	}
	
	
	
}
