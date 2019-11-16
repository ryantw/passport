package com.pwandp.store.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Slf4j
@Table(name = "order_size_quantities")
public class OrderSizeQuantities implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JsonIgnore
    @OneToOne
    private Order order;

    @Column(name = "age0_3m")
    private int age0to3months;

    @Column(name = "age3_6m")
    private int age3to6months;

    @Column(name = "age6_12m")
    private int age6to12months;

    @Column(name = "age12_18m")
    private int age12to18months;

    @Column(name = "age18_24m")
    private int age18to24months;

    @Column(name = "age2t")
    private int age2t;

    @Column(name = "age2_3y")
    private int age2to3year;

    @Column(name = "age3t")
    private int age3t;

    @Column(name = "age3_4y")
    private int age3to4year;

    @Column(name = "age4t")
    private int age4t;

    @Column(name = "age4_5y")
    private int age4to5year;

    @Column(name = "age5_6y")
    private int age5to6year;

    @Column(name = "age6_7y")
    private int age7to6year;

    @Column(name = "age7_8y")
    private int age7to8year;

    @Column(name = "age8_9y")
    private int age8to9year;

    @Column(name = "age9_10y")
    private int age9to10year;

    @Column(name = "age10_12y")
    private int age10to12year;

    @Column(name = "age12_14y")
    private int age12to14year;

    @Column(name = "age14_16y")
    private int age14to16year;

}
