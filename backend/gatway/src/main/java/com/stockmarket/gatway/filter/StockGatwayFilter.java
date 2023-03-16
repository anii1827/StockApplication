package com.stockmarket.gatway.filter;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferFactory;
import org.springframework.core.io.buffer.DefaultDataBuffer;
import org.springframework.core.io.buffer.DefaultDataBufferFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import com.stockmarket.gatway.exception.StockGatwayException;
import com.stockmarket.gatway.util.JwtUtil;

import io.jsonwebtoken.Claims;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class StockGatwayFilter implements GatewayFilter {

	final List<String> apiEndpoints = List.of("/withoutPassword","/auth","/information","/api/v1.0/market/company/info","/api/v1.0/market/stock/get");
	private final String Expired = "isExpired";
	
	@Autowired
	JwtUtil jwt;
	
	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) { 
		ServerHttpRequest request = exchange.getRequest();
		
		Predicate<ServerHttpRequest> isApiSecured = x ->  apiEndpoints.stream().noneMatch(y->x.getURI().getPath().contains(y));
		
		if(isApiSecured.test(request)) {
			if(!request.getHeaders().containsKey("Authorization")) {
				ServerHttpResponse  response = exchange.getResponse();
				response.setStatusCode(HttpStatus.UNAUTHORIZED);
				String body = "Unauthorized Request";
				Flux<DefaultDataBuffer> data = Flux.just(new DefaultDataBufferFactory().wrap(body.getBytes(StandardCharsets.UTF_8)));
				response.writeWith(data);
				System.out.println(request.getURI().getPath()+" -> "+ HttpStatus.UNAUTHORIZED.toString());
				return response.setComplete();
			}
			
			final String token = request.getHeaders().getOrEmpty("Authorization").get(0);
			
			try {
				jwt.validateToken(token);
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
				ServerHttpResponse  response = exchange.getResponse();
				response.setStatusCode(HttpStatus.REQUEST_TIMEOUT);
				Flux<DefaultDataBuffer> data = Flux.just(new DefaultDataBufferFactory().wrap(e.getMessage().getBytes(StandardCharsets.UTF_8)));
				response.writeWith(data);
				return response.setComplete();
			}
			
			if(Expired.contains(request.getURI().getPath())) {
				ServerHttpResponse  response = exchange.getResponse();
				Flux<DefaultDataBuffer> data = Flux.just(new DefaultDataBufferFactory().wrap("OK".getBytes(StandardCharsets.UTF_8)));
				response.writeWith(data);
				response.setStatusCode(HttpStatus.OK);
				return response.setComplete();
			}
			Claims claims = jwt.getClaims(token);
			exchange.getRequest().mutate().header("username", claims.getSubject().toString());
			exchange.getRequest().getHeaders().get("username").stream().forEach(System.out::println);
		}
		
		
		return chain.filter(exchange);
	}

}
