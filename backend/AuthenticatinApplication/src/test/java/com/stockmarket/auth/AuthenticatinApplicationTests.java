package com.stockmarket.auth;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stockmarket.auth.exception.StockAuthException;
import com.stockmarket.auth.login.LoginData;
import com.stockmarket.auth.util.JwtUtil;

@SpringBootTest
class AuthenticatinApplicationTests {

	@Test
	void contextLoads() throws StockAuthException, Exception {
		
		JwtUtil jwt = new JwtUtil();
		String token = jwt.generateToken("admin");
		
		jwt.validateToken(token);
		
		System.out.println(jwt.getClaims(token).getSubject());
		
	}
	
	 @Autowired
	  WebApplicationContext webApplicationContext; 
	 
	@Test
	void testApi() throws Exception {
		MockMvc mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		
		LoginData data = new LoginData();
		data.setUsername("admin");data.setPassword("passwrod");
		String writeValueAsString = new ObjectMapper().writeValueAsString(data);
		
		MvcResult andReturn = mvc.perform(MockMvcRequestBuilders.get("/api/v1.0/market/auth/login")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(writeValueAsString)).andReturn();
		System.out.println(andReturn.getResponse().getContentAsString());
	}

}
