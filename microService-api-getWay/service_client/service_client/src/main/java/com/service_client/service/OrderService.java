package com.service_client.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.service_client.model.Order;



@Service
public class OrderService {
	private RestTemplate restTemplate = new RestTemplate();
    private String url = "http://localhost:8080/api/";

    public Order createOrder(Order order) {
		return restTemplate.postForObject(url+"createOrder", order, Order.class);
	}
    public List<Order> listOrder() {
		ResponseEntity<Order[]> responseEntity = restTemplate.getForEntity(url+"orders",Order[].class);
		return Arrays.asList(responseEntity.getBody());
	}
    public Order getOrder(Long id) {
		ResponseEntity<Order> responseEntity = restTemplate.getForEntity(url+"order/"+id, Order.class);
		return responseEntity.getBody();
	}
    public void deleteOrder(Long id) {
    	 restTemplate.getForEntity(url+"order/"+id, Order.class);
		
	}
}
