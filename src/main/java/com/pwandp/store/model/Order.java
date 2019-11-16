package com.pwandp.store.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@EqualsAndHashCode(exclude = {"customer"})
@Slf4j
@Table(name = "preorders")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Date dateOrdered = new Date();

    private String payType;

    private String pickUpLocation;

    private BigDecimal total;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "order")
    private OrderSizeQuantities orderSizeQuantities;


    @OneToOne
    private Product product;

    // TODO: rework customer/order relationship
    @JsonIgnore
    @ManyToOne
    private Customer customer;

}
