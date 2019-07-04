package com.myapp.ws.rest.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myapp.ws.rest.model.Order;
import com.myapp.ws.rest.repository.OrdersRepository;

@Service
public class OrderServiceImpl implements OrdersService {

	@Autowired
	private OrdersRepository ordersRepository;

	@Override
	public String addNewProduct(Order order) {
// TODO Auto-generated method stub
		ordersRepository.save(order);
		return order.getProductName();
	}

	@Override
	public List<Order> findByName(String name) {
// TODO Auto-generated method stub
		return ordersRepository.findByProductName(name);
	}

	@Override
	public List<Order> findAll() {
// TODO Auto-generated method stub
		return ordersRepository.findAll();
	}

	@Override
	public String update(Order order) {
// TODO Auto-generated method stub
		Order existingOrder = ordersRepository.findById(order.getProductId()).get();
		BeanUtils.copyProperties(order, existingOrder);
		ordersRepository.save(existingOrder);
		return existingOrder.getProductName();
	}

	@Override
	public String delete(int productId) {

		Order existingOrder = ordersRepository.findById(productId).get();
		ordersRepository.delete(existingOrder);
		return existingOrder.getProductName() + " deleted ";
	}

}