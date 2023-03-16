package com.stockmarket.aggregator.config;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

import com.stockmarket.aggregator.exception.customStockException;

public class RestErrorResponseHandler implements ResponseErrorHandler {

	private static final Logger logger= LoggerFactory.getLogger(ResponseErrorHandler.class);
	
	@Override
	public boolean hasError(ClientHttpResponse response) throws IOException {
		return (response.getStatusCode().is1xxInformational() || response.getStatusCode().is3xxRedirection() 
				|| response.getStatusCode().is5xxServerError() || response.getStatusCode().is4xxClientError());
	}

	@Override
	public void handleError(ClientHttpResponse response) throws IOException {
		String data = getData(response.getBody());
		logger.error("StockApplication : "+data);
		throw new customStockException(data);
	}
	
	private String getData(InputStream stream) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(stream));
		StringBuilder data = new StringBuilder("");
		String line;
		  while ((line = br.readLine()) != null) {
	            data.append(line);
	        }
		  return data.toString();
	}
}
