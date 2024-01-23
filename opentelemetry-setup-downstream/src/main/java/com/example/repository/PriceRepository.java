package com.example.repository;

import com.example.exception.PriceNotFoundException;
import com.example.model.Price;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Repository
public class PriceRepository {
    private final Map<Long, Price> priceMap = new HashMap<>();

    @PostConstruct
    private void setupRepo() {
        setupProduct(100001L, 12.5, 2.5);
        setupProduct(100002L, 10.5, 2.1);
        setupProduct(100003L, 18.5, 2.0);
        setupProduct(100004L, 18.5, 2.0);
    }

    private void setupProduct(long id, double amount, double discount) {
        priceMap.put(id, new Price(id, amount, discount));
    }

    public Price findPriceById(Long productId) {
        log.info("find price from price repo with product id = {}", productId);
        if(!contains(productId)) {
            throw new PriceNotFoundException();
        }

        return priceMap.get(productId);
    }

    private boolean contains(Long productId) {
        boolean isContain = priceMap.containsKey(productId);
        if(!isContain) {
            log.warn("price not found for product id = {}", productId);
        }

        return isContain;
    }
}
