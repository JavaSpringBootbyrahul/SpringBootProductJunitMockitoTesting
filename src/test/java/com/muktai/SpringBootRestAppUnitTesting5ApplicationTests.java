package com.muktai;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
@AutoConfigureMockMvc
@TestPropertySource("classpath:application-test.properties")
class SpringBootRestAppUnitTesting5ApplicationTests 
{
	@Autowired
	MockMvc mockMvc;
	
	@Test
	@Disabled
	void testSaveProduct() throws Exception 
	{
		//1. Creates dummy request
		MockHttpServletRequestBuilder request=MockMvcRequestBuilders.post("/product/save")
							.contentType(MediaType.APPLICATION_JSON)
							.content("{\"name\":\"Fridge\",\"color\":\"Red\",\"price\":\"23000\",\"description\":\"THis is fridge\"}");
		//2. execute the request
		MvcResult result=mockMvc.perform(request).andReturn();
		
		//3. reads the response
		MockHttpServletResponse response=result.getResponse();
		
		//4. test the response using assert api
		assertEquals(HttpStatus.OK.value(),response.getStatus());
		
		if(!response.getContentAsString().contains("Product Created"))
		{
			fail("Product not created!!!!");
		}
	}
	
	@Test
	@Disabled
	public void testGetAllProducts() throws Exception
	{
		//1. create dummy request
		MockHttpServletRequestBuilder request=MockMvcRequestBuilders.get("/product/all");
		//2. execute that request and get the result
		MvcResult result=mockMvc.perform(request).andReturn();
		//3. read the response
		MockHttpServletResponse resposne=result.getResponse();
		//4. test the response assert methods status 200 
		assertEquals(HttpStatus.OK.value(),resposne.getStatus());
		assertEquals(MediaType.APPLICATION_JSON_VALUE, resposne.getContentType());
		if(resposne.getContentAsString().isEmpty())
		{
			fail("Products not found....");
		}
	}
		
		@Test
		@Disabled
		public void testGetOneProduct() throws Exception
		{
			//1. create dummy request
			MockHttpServletRequestBuilder request=MockMvcRequestBuilders.get("/product/one/4");
			//2. execute that request and get the result
			MvcResult result=mockMvc.perform(request).andReturn();
			//3. read the response
			MockHttpServletResponse resposne=result.getResponse();
			//4. test the response assert methods status 200 
			assertEquals(HttpStatus.OK.value(),resposne.getStatus());
			assertEquals(MediaType.APPLICATION_JSON_VALUE, resposne.getContentType());
			if(resposne.getContentAsString().isEmpty())
			{
				fail("Product not found....");
			}

	}
		@Test
		public void testGetOneProductNotFound() throws Exception
		{
			//1. create dummy request
			MockHttpServletRequestBuilder request=MockMvcRequestBuilders.get("/product/one/70");
			//2. execute that request and get the result
			MvcResult result=mockMvc.perform(request).andReturn();
			//3. read the response
			MockHttpServletResponse resposne=result.getResponse();
			//4. test the response assert methods status 404
			assertEquals(HttpStatus.NOT_FOUND.value(),resposne.getStatus());

	}

}
