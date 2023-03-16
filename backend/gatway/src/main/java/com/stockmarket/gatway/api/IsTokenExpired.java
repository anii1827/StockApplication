package com.stockmarket.gatway.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stockmarket.gatway.util.JwtUtil;

@RestController
@RequestMapping("/isExpired")
public class IsTokenExpired {

	@Autowired
	JwtUtil jwt;
	
	@PostMapping("")
	public ResponseEntity<?> isExpired(@RequestBody String token){
		try {
			jwt.validateToken(token);
		}catch(Exception ex) {
			return new ResponseEntity<String>("TOKEN EXPIRED",HttpStatus.REQUEST_TIMEOUT);
		}
		
		return new ResponseEntity<String>("OK",HttpStatus.OK);
	}
	
}
