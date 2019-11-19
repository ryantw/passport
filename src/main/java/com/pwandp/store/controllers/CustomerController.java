package com.pwandp.store.controllers;

import com.pwandp.store.service.CustomerServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customer")
@Slf4j
public class CustomerController {

    private final CustomerServiceImpl customerService;

    public CustomerController(CustomerServiceImpl customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<?> getOrders(){
        // TODO: implement return if enabled
        return ResponseEntity.ok(customerService.findAll());
    }

    @GetMapping("/search/{emailAddress}")
    public ResponseEntity<?> getCustomerByEmail(@PathVariable String emailAddress){
        return ResponseEntity.ok(customerService.findByEmailAddress(emailAddress));
    }
}
