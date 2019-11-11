package com.pwandp.store.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Slf4j
@Table(name = "product_sizes")
public class AllSizes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "0_3m")
    private boolean age0to3months;

    @Column(name = "3_6m")
    private boolean age3to6months;

    @Column(name = "6_12m")
    private boolean age6to12months;

    @Column(name = "12_18m")
    private boolean age12to18months;

    @Column(name = "18_24m")
    private boolean age18to24months;

    @Column(name = "2t")
    private boolean age2t;

    @Column(name = "2_3y")
    private boolean age2to3year;

    @Column(name = "3t")
    private boolean age3t;

    @Column(name = "3_4y")
    private boolean age3to4year;

    @Column(name = "4t")
    private boolean age4t;

    @Column(name = "4_5y")
    private boolean age4to5year;

    @Column(name = "5_6y")
    private boolean age5to6year;

    @Column(name = "6_7y")
    private boolean age7to6year;

    @Column(name = "7_8y")
    private boolean age7to8year;

    @Column(name = "8_9y")
    private boolean age8to9year;

    @Column(name = "9_10y")
    private boolean age9to10year;

    @Column(name = "10_12y")
    private boolean age10to12year;

    @Column(name = "12_14y")
    private boolean age12to14year;

    @Column(name = "14_16y")
    private boolean age14to16year;

    @JsonIgnore
    @OneToOne
    private Product productSizes;
}
