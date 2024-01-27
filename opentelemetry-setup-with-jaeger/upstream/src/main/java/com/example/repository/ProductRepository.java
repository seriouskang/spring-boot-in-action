package com.example.repository;

import com.example.api.client.PriceClient;
import com.example.exception.ProductNotFoundException;
import com.example.model.Price;
import com.example.model.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Repository
@RequiredArgsConstructor
public class ProductRepository {
    private final PriceClient priceClient;
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
        validateId(id);

        Product product = productMap.get(id);
        product.setPrice(findPriceById(id));
        return product;
    }

    private Price findPriceById(Long id) {
        return priceClient.price(id);
    }

    private void validateId(Long id) {
        if(!contains(id)) {
            log.error("product not found = {}", id);
            throw new ProductNotFoundException("product not found = " + id);
        }
    }

    private boolean contains(Long id) {
        return productMap.containsKey(id);
    }
}
