package com.stockmarket.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stockmarket.auth.util.JwtUtil;

@Service
public class AuthService {

	@Autowired
	JwtUtil jwt;
	
	public String generateToken(String username) {
		String generateToken = jwt.generateToken(username);
		return generateToken;
	}
}
