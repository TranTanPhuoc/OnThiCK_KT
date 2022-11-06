package com.retry.service;

import java.util.List;

import com.retry.model.Order;


public interface OrderService {
	public Order createOrder(Order order);
	public List<Order> listOrder();
	public Order getOrder(Long id);
	public void deteleOrder(Long id);
}
