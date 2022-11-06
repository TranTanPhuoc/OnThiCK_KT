package com.redis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.redis.model.Order;
import com.redis.service.OrderService;



@RestController
@RequestMapping("/api")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@GetMapping("/orders")
	@Cacheable(value = "order")
	public List<Order> getListOrder(){
		List<Order> orders  = orderService.listOrder();
		return orders;
	}
	@GetMapping("/order/{id}")
	@Cacheable(value = "order",key = "#id")
	public Order getOrder(@PathVariable(value = "id") Long id){
		Order order  = orderService.getOrder(id);
		System.out.println("Order fetching from database:: "+id);
		return order;
	}
	@PostMapping("/createOrder")
	@CachePut(value = "order")
	public ResponseEntity<Order> createOrder(@RequestBody Order order){
		 order = orderService.createOrder(order);
		 System.out.println("Order is create ::"+order);
		return ResponseEntity.ok(order);
	}
	@GetMapping("/deleteOrder/{id}")
	@CacheEvict(value = "order", allEntries = true)
	public String deteleOrder(@PathVariable(value = "id") Long id) {
		orderService.deteleOrder(id);
		return "Xóa thành công";
	}
	
	
	@PutMapping("/orderUpdate/{id}")
	@CachePut(value = "order",key = "#id")
	public Order updateOrder(@PathVariable(value = "id") Long id,@RequestBody Order orderDetail) {
		Order order = orderService.updateOrder(id, orderDetail);
		System.out.println("Order ( "+id+") is Update::"+order);
		return order;
	}
	
}
