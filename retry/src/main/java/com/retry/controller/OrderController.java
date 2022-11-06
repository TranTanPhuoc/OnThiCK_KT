package com.retry.controller;

import java.time.Duration;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.retry.model.Order;
import com.retry.service.OrderService;

import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.RetryConfig;
import io.github.resilience4j.retry.RetryRegistry;

@RestController
@RequestMapping("/api")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@GetMapping("/orders")
	public List<Order> getListOrder() {
		RetryConfig config = RetryConfig.custom()
				  .maxAttempts(3)
				  .waitDuration(Duration.ofSeconds(5))
				  .build();
		RetryRegistry registry = RetryRegistry.of(config);
		Retry retry = registry.retry("orderService", config);
		List<Order> orders = retry.executeSupplier(() -> orderService.listOrder());
		return orders;
	}

	@GetMapping("/order/{id}")
	public Order getOrder(@PathVariable Long id) {
		RetryConfig config = RetryConfig.custom().maxAttempts(3).waitDuration(Duration.ofSeconds(5)).build();
		RetryRegistry registry = RetryRegistry.of(config);
		Retry retry = registry.retry("orderService", config);
		Order order = retry.executeSupplier(()-> orderService.getOrder(id));
		return order;
	}

	@PostMapping("/createOrder")
	public ResponseEntity<Order> createOrder(@RequestBody Order order) {
		order = orderService.createOrder(order);
		return ResponseEntity.ok(order);
	}

	@GetMapping("/deleteOrder/{id}")
	public String deteleOrder(@PathVariable Long id) {
		orderService.deteleOrder(id);
		return "Xóa thành công";
	}
}
