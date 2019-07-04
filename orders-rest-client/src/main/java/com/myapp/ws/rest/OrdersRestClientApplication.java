package com.myapp.ws.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrdersRestClientApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(OrdersRestClientApplication.class, args);
	}

	
 
	@Autowired
	private OrdersRestClient restClient;
	
	@Override
	public void run(String... args) throws Exception {
	
		System.out.println(restClient.getOrders());
		

		
	}

}
