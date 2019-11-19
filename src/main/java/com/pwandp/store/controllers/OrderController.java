package com.pwandp.store.controllers;

import com.pwandp.store.model.Order;
import com.pwandp.store.service.OrderServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
@Slf4j
public class OrderController {

    private final OrderServiceImpl orderService;

    public OrderController(OrderServiceImpl orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<?> getOrders(){
        // TODO: implement return if enabled
        return ResponseEntity.ok(orderService.findAll());
    }

    @PostMapping("/new")
    public ResponseEntity<?> saveOrder(@RequestBody Order order){
        return ResponseEntity.ok(orderService.save(order));
    }
}
