package com.redis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redis.model.Order;
import com.redis.reponsitory.OrderResponsitory;



@Service
public class OrderServiceImpl implements OrderService  {

	@Autowired
	private OrderResponsitory orderResponsitory;
	
	
	@Override
	public Order createOrder(Order order) {
		// TODO Auto-generated method stub
		return orderResponsitory.save(order);
	}

	@Override
	public List<Order> listOrder() {
		// TODO Auto-generated method stub
		List<Order> orders = (List<Order>) orderResponsitory.findAll();
		return orders;
	}

	@Override
	public Order getOrder(Long id) {
		Order order = orderResponsitory.findById(id).orElse(null);
		return order;
	}

	@Override
	public void deteleOrder(Long id) {
		orderResponsitory.deleteById(id);
	}

	@Override
	public Order updateOrder(Long id,Order orderDetail) {
		Order order = orderResponsitory.findById(id).orElse(null);
		order.setOrderName(orderDetail.getOrderName());
		order.setPrice(orderDetail.getPrice());
		order.setNgayLap(orderDetail.getNgayLap());
		final Order updateOrder = orderResponsitory.save(order);
		return updateOrder;
	}

}
