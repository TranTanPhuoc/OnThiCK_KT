package com.service.reponsitory;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.service.model.Order;

@Repository
public interface OrderResponsitory extends CrudRepository<Order, Long> {

}
