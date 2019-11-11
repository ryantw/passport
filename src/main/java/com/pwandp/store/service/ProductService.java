package com.pwandp.store.service;

import com.pwandp.store.model.Product;
import org.springframework.stereotype.Service;

@Service
public interface ProductService extends CrudService<Product, Long> {
    void disableProduct(Long id);
}
