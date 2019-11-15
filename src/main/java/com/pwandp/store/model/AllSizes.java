package com.pwandp.store.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@EqualsAndHashCode(exclude = {"productSizes"})
@Slf4j
@Table(name = "product_sizes")
public class AllSizes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "age0_3m")
    private boolean age0to3months;

    @Column(name = "age3_6m")
    private boolean age3to6months;

    @Column(name = "age6_12m")
    private boolean age6to12months;

    @Column(name = "age12_18m")
    private boolean age12to18months;

    @Column(name = "age18_24m")
    private boolean age18to24months;

    @Column(name = "age2t")
    private boolean age2t;

    @Column(name = "age2_3y")
    private boolean age2to3year;

    @Column(name = "age3t")
    private boolean age3t;

    @Column(name = "age3_4y")
    private boolean age3to4year;

    @Column(name = "age4t")
    private boolean age4t;

    @Column(name = "age4_5y")
    private boolean age4to5year;

    @Column(name = "age5_6y")
    private boolean age5to6year;

    @Column(name = "age6_7y")
    private boolean age7to6year;

    @Column(name = "age7_8y")
    private boolean age7to8year;

    @Column(name = "age8_9y")
    private boolean age8to9year;

    @Column(name = "age9_10y")
    private boolean age9to10year;

    @Column(name = "age10_12y")
    private boolean age10to12year;

    @Column(name = "age12_14y")
    private boolean age12to14year;

    @Column(name = "age14_16y")
    private boolean age14to16year;

    @JsonIgnore
    @OneToOne
    private Product productSizes;
}
