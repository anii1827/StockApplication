package com.stockmarket.auth.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stockmarket.auth.service.AuthService;

@RestController
@RequestMapping("/api/v1.0/market/auth/")
public class LoginApi {

		@Autowired
		AuthService service;
		
		@RequestMapping(method = RequestMethod.POST, value = "/login")
		public ResponseEntity<?> login(@RequestBody LoginData data) {
			System.out.println(data.getUsername()+"    "+data.getPassword());
			if("admin".equals(data.getUsername()) && "password".equals(data.getPassword())) {
				String generateToken = service.generateToken(data.getUsername());
				return new ResponseEntity<String>(generateToken, HttpStatus.OK);
			}else {
				return new ResponseEntity<String>("Username and password are incorrect", HttpStatus.BAD_REQUEST);
			}
	}
		
}
