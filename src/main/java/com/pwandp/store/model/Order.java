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
@Table(name = "preorder")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String emailAddress;

    private String paypalEmailAddress;

    private String firstName;

    private String lastName;

    private Date dateOrdered = new Date();

    private String payType;

    private String pickUpLocation;

    private BigDecimal total;

    // Canceled or not, basically.
    private boolean enabled;

    @OneToOne(cascade = CascadeType.ALL)
    private OrderSizeQuantities orderSizeQuantities;

    @OneToOne
    private Product product;
}
