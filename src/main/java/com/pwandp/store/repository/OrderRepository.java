package com.pwandp.store.repository;

import com.pwandp.store.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    Order findByEmailAddress(String emailAddress);
}
