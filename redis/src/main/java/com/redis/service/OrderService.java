package com.redis.service;

import java.util.List;

import com.redis.model.Order;



public interface OrderService {
	public Order createOrder(Order order);
	public List<Order> listOrder();
	public Order getOrder(Long id);
	public void deteleOrder(Long id);
	public Order updateOrder(Long id,Order orderDetail);
}
