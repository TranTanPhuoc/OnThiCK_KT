package com.clientCloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clientCloud.model.Order;
import com.clientCloud.service.OrderService;





@RestController
@RefreshScope
@RequestMapping("/api")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@GetMapping("/orders")
	public List<Order> getListOrder(){
		List<Order> orders  = orderService.listOrder();
		return orders;
	}
	@GetMapping("/order/{id}")
	public Order getOrder(@PathVariable Long id){
		Order order  = orderService.getOrder(id);
		return order;
	}
	@PostMapping("/createOrder")
	public ResponseEntity<Order> createOrder(@RequestBody Order order){
		 order = orderService.createOrder(order);
		return ResponseEntity.ok(order);
	}
	@GetMapping("/deleteOrder/{id}")
	public String deleteOrder(@PathVariable Long id) {
		orderService.deleteOrder(id);
		return "Xóa thành công";
	}
}
