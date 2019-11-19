package com.pwandp.store.service;

import com.pwandp.store.model.Customer;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService extends CrudService<Customer, Long> {
    Customer findByEmailAddress(String emailAddress);
}
