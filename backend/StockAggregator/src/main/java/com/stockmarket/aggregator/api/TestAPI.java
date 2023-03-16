package com.stockmarket.aggregator.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1.0/test/")
public class TestAPI {
	
	@GetMapping(value = "/withPassword")
	public String check() {
		return "It's withPassword";
	}

	@GetMapping(value = "/withoutPassword")
	public String check2() {
		return "It's withoutPassword";
	}
}
