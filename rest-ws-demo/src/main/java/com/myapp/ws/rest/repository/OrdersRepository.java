package com.myapp.ws.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.myapp.ws.rest.model.Order;

public interface OrdersRepository extends JpaRepository< Order, Integer>{
    List<Order> findByProductName(String productName);
    
    
}
