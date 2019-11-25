package com.pwandp.store.service;

import com.pwandp.store.model.Customer;
import com.pwandp.store.model.Order;
import com.pwandp.store.repository.CustomerRepository;
import com.pwandp.store.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> findAll() {
        List<Order> orders = new ArrayList<>();
        orderRepository.findAll().forEach(orders::add);
        return orders;
    }

    @Override
    public Order findById(Long aLong) {
        return orderRepository.findById(aLong)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }

    @Override
    public Order findByEmailAddress(String emailAddress) {
        Optional<Order> order = Optional.ofNullable(orderRepository.findByEmailAddress(emailAddress));
        if(order.isPresent()){
            return order.get();
        }
        throw new RuntimeException("Error finding order.");
    }

    @Override
    public Order save(Order object) {
        return orderRepository.save(object);
    }

    @Override
    public void delete(Order object) {
        orderRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        orderRepository.deleteById(aLong);
    }
}
