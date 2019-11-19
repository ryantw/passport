package com.pwandp.store.service;

import com.pwandp.store.model.Customer;
import com.pwandp.store.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> findAll(){
        List<Customer> customers = new ArrayList<>();
        customerRepository.findAll().forEach(customers::add);
        return customers;
    }

    @Override
    public Customer findById(Long aLong) {
        return null;
    }

    @Override
    public Customer save(Customer object) {
        return customerRepository.save(object);
    }

    @Override
    public void delete(Customer object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public Customer findByEmailAddress(String emailAddress) {
        return customerRepository.findByEmailAddress(emailAddress);
    }
}
