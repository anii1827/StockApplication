package com.stockmarket.stock.model;

import org.springframework.http.HttpStatus;

public class Response {
		private String Message;
		private HttpStatus status;
		public Response(String message, HttpStatus status) {
			this.Message = message;
			this.status = status;
		}
		
		
}
