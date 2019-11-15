package com.pwandp.store.bootstrap;

import com.pwandp.store.model.AllSizes;
import com.pwandp.store.model.Product;
import com.pwandp.store.service.ProductServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.javamoney.moneta.Money;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;

@Component
@Slf4j
public class ProductStartUpData implements CommandLineRunner {

    private final ProductServiceImpl productService;

    public ProductStartUpData(ProductServiceImpl productService) {
        this.productService = productService;
    }

    @Override
    public void run(String... args) throws Exception {
        loadProduct();
    }

    protected void loadProduct(){

        AllSizes productOneAllSizes = AllSizes.builder()
                .age0to3months(true)
                .age2t(true)
                .age12to18months(true)
                .build();

        Product product = Product.builder()
                .name("T-Shirt")
                .description("Long flannel looking")
                .price(new BigDecimal(19.00))
                .productSize(productOneAllSizes)
                .build();

        AllSizes productTwoAllSizes = AllSizes.builder()
                .age0to3months(true)
                .age2t(true)
                .age12to18months(true)
                .age3to6months(true)
                .age14to16year(true)
                .build();

        Product productTwo = Product.builder()
                .name("Dress")
                .description("Flowing Flannel")
                .price(new BigDecimal(22.00))
                .productSize(productTwoAllSizes)
                .build();

        productService.save(product);
        productService.save(productTwo);

    }
}
