package com.myapp.ws.rest;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;
import org.springframework.stereotype.Component;

import com.myapp.ws.rest.model.Order;


@Component
public class OrdersRestClient {
	
	public List<Order> getOrders()
	{
		
		Client client = ClientBuilder.newClient( new ClientConfig() );
		WebTarget webTarget = client.target("http://localhost:8003/api").path("orderapi");

		// Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
	
		//http://localhost:8003/api/order/iphone
		 Invocation.Builder invocationBuilder = webTarget.path("/blackberry").request(MediaType.APPLICATION_JSON);
		
		Response response = invocationBuilder.get();
		
		List<Order>list=response.readEntity(List.class);
	
		return list;
	
	}

}
