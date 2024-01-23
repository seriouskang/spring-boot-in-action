package com.example.repository;

import com.example.exception.ProductNotFoundException;
import com.example.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Repository
public class ProductRepository {
    private final Map<Long, Product> productMap = new HashMap<>();

    @PostConstruct
    private void setupRepo() {
        setupProduct(100001L, "apple");
        setupProduct(100002L, "pears");
        setupProduct(100003L, "banana");
        setupProduct(100004L, "mango");
        setupProduct(100005L, "test");
    }

    private void setupProduct(Long id, String name) {
        productMap.put(id, new Product(id, name));
    }

    public Product findProductById(Long id) {
        log.info("get product from product repo with product id = {}", id);

        if(!contains(id)) {
            throw new ProductNotFoundException();
        }

        return productMap.get(id);
    }

    private boolean contains(Long id) {
        boolean isContain = productMap.containsKey(id);
        if(!isContain) {
            log.warn("product not found for product id = {}", id);
        }

        return isContain;
    }
}
