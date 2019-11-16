package com.pwandp.store.bootstrap;

import com.pwandp.store.model.*;
import com.pwandp.store.service.CustomerServiceImpl;
import com.pwandp.store.service.OrderServiceImpl;
import com.pwandp.store.service.ProductServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.javamoney.moneta.Money;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;

@Component
@Slf4j
public class ProductStartUpData implements CommandLineRunner {

    private final ProductServiceImpl productService;
    private final OrderServiceImpl orderService;
    private final CustomerServiceImpl customerService;

    public ProductStartUpData(ProductServiceImpl productService, OrderServiceImpl orderService,
                              CustomerServiceImpl customerService) {
        this.productService = productService;
        this.orderService = orderService;
        this.customerService = customerService;
    }

    @Override
    public void run(String... args) throws Exception {
        loadProduct();
        loadOrder();
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

    protected void loadOrder(){

        Product productOne = productService.findById(1L);

        Customer customer = Customer.builder()
                .emailAddress("r@r.com")
                .firstName("Ryan")
                .lastName("Walker")
                .build();

        Order order = Order.builder()
                .customer(customer)
                .payType("PAYPAL")
                .pickUpLocation("ETOWN")
                .total(new BigDecimal(42.99))
                .product(productOne)
                .build();

        OrderSizeQuantities orderSizeQuantities = OrderSizeQuantities.builder()
                .order(order)
                .age0to3months(3)
                .age10to12year(2)
                .age3t(1)
                .build();

        Order order1 = Order.builder()
                .customer(customer)
                .payType("PAYPAL")
                .pickUpLocation("MVILLE")
                .total(new BigDecimal(19.99))
                .product(productOne)
                .build();

        OrderSizeQuantities orderSizeQuantities1 = OrderSizeQuantities.builder()
                .order(order1)
                .age14to16year(1)
                .build();

        order.setOrderSizeQuantities(orderSizeQuantities);
        order1.setOrderSizeQuantities(orderSizeQuantities1);
        customer.setOrders(Arrays.asList(order, order1));

        customerService.save(customer);

    }
}
