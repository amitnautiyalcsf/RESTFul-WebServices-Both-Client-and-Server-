package com.myapp.ws.rest.endpoint;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;

import com.myapp.ws.rest.model.Order;
import com.myapp.ws.rest.service.OrdersService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

// http://IP:PORT/context/orders
@Path("orderapi")

@Api(value = "OrderService", produces = "application/json")
public class OrdersRestEndpoint {

	@Autowired
	private OrdersService service;

	@GET
	@Path("{productName}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@ApiOperation( // Swagger Annotation
			value = "Find Order By name", response = List.class)
	@ApiResponses(value = { // Swagger Annotation
			@ApiResponse(code = 200, message = "Resource found"),
			@ApiResponse(code = 404, message = "Resource not found") })
	public Response findByProductName(@PathParam("productName") String productName) {
		Response response = Response.status(Status.CREATED).entity(service.findByName(productName)).build();
		return response;
	}

	@POST
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public String addNewOrder(Order order) {

		return service.addNewProduct(order);
	}

	@PUT
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public String updateExistingOrder(Order order) {

		return service.update(order);
	}

	@DELETE
	@Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public String deleteExistingOrder(@PathParam("id") int productId) {

		return service.delete(productId);
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Order> findAllProducts() {
		return service.findAll();
	}

}