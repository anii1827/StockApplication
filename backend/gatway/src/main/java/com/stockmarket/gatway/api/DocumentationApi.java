//package com.stockmarket.gatway.api;
//
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
//import org.springframework.cloud.gateway.route.RouteLocator;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.stereotype.Component;
//
//import springfox.documentation.swagger.web.SwaggerResource;
//import springfox.documentation.swagger.web.SwaggerResourcesProvider;
//
//@Component
//@Primary 
//@EnableAutoConfiguration
//public class DocumentationApi implements SwaggerResourcesProvider{
//	
//	@Autowired
//	RouteLocator locator;
//	
//	@Autowired
//	RouteDefinitionLocator loc;
//	
//	public static final String API_URI = "/v2/api-docs";
//	
//
//	@Override
//	public List<SwaggerResource> get() {
////		List<SwaggerResource> resources = new ArrayList<>();
//		List<SwaggerResource> resources = new ArrayList<>();
//		resources.add(swaggerResource("StockAggregator","/api/v1.0/market/information/v2/api-docs"));
////		locator.getRoutes().all(x->
////		resources.add(swaggerResource(x.getId(),x.getUri().getPath().replace("**", "v2/api-docs"))));
////		System.out.println();
////		resources.stream().forEach(x->System.out.println(x.getLocation()));
////		System.out.println();
////	        loc.getRouteDefinitions().subscribe(routeDefinition -> {
////	            String resourceName = routeDefinition.getId();
////	            String location = routeDefinition.getUri().toString().replace("**", API_URI);
////	            System.out.println(location);
////	            resources.add(swaggerResource(resourceName, location));
////	        });
//		
//		return resources;
//	}
//
//	private SwaggerResource swaggerResource(String name, String location) {
//		 SwaggerResource swaggerResource = new SwaggerResource();
//	        swaggerResource.setName(name);
//	        swaggerResource.setLocation(location);
//	        swaggerResource.setSwaggerVersion("1.0");
//	        return swaggerResource;
//	}
//	
//	
//	
//	
//
//	
//	
//}
