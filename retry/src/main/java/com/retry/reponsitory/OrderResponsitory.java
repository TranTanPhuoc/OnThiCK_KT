package com.retry.reponsitory;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.retry.model.Order;


@Repository
public interface OrderResponsitory extends CrudRepository<Order, Long> {

}
