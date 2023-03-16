//package com.stockmarket.gatway.api;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import reactor.core.publisher.Mono;
//import springfox.documentation.swagger.web.SecurityConfiguration;
//import springfox.documentation.swagger.web.SwaggerResourcesProvider;
//import springfox.documentation.swagger.web.UiConfiguration;
//
//
//@RestController
//@RequestMapping("/swagger-resources")
//public class SwaggerHandler {
//
//	  
//    @Autowired(required = false)
//    private SecurityConfiguration securityConfiguration;
//    
//    @Autowired(required = false)
//    private UiConfiguration uiConfiguration;
//
//    private final SwaggerResourcesProvider swaggerResources;
//
//    @Autowired
//    public SwaggerHandler(SwaggerResourcesProvider swaggerResources) {
//        this.swaggerResources = swaggerResources;
//    }
//
//    
//    public Mono<ResponseEntity<SecurityConfiguration>> securityConfiguration() {
//        return Mono.just(new ResponseEntity<>(
//            securityConfiguration, HttpStatus.OK));
//
//    }
//
//    
//
//    @GetMapping("")
//    public Mono<ResponseEntity<?>> swaggerResources() {
//        return Mono.just((new ResponseEntity<>(swaggerResources.get(), HttpStatus.OK)));
//    }      
//	
//}
//
