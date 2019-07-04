package com.myapp.ws.rest.service;

import java.util.List;

import com.myapp.ws.rest.model.Order;

public interface OrdersService {
	
	String addNewProduct(Order order);
	List<Order> findByName(String Name);
	List<Order>findAll();
	String update(Order order);
	String delete(int productId);

}
