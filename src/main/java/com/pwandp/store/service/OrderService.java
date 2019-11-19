package com.pwandp.store.service;

import com.pwandp.store.model.Customer;
import com.pwandp.store.model.Order;
import org.springframework.stereotype.Service;

@Service
public interface OrderService extends CrudService<Order, Long> {

}
