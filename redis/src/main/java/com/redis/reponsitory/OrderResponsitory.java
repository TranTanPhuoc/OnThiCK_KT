package com.redis.reponsitory;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.redis.model.Order;


@Repository
public interface OrderResponsitory extends CrudRepository<Order, Long> {

}
