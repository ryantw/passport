package com.pwandp.store.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
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
@Slf4j
@Table(name = "products")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String description;

    private String picture;

    private BigDecimal price;

    private boolean enabled;

    private boolean pickUp;

    private boolean ship;

    private Date dateAdded = new Date();

    private Date lastModified = new Date();

    private Date closeProduct = new Date();

    @OneToOne(cascade = CascadeType.ALL)
    private AllSizes productSize;

}
