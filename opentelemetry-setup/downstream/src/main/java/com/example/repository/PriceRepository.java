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
        setupPrice(100001L, 12.5, 2.5);
        setupPrice(100002L, 10.5, 2.1);
        setupPrice(100003L, 18.5, 2.0);
        setupPrice(100004L, 18.5, 2.0);
    }

    private void setupPrice(long id, double amount, double discount) {
        priceMap.put(id, new Price(id, amount, discount));
    }

    public Price findPriceById(Long id) {
        log.info("find price from price repo with product id = {}", id);
        validateId(id);
        return priceMap.get(id);
    }

    private void validateId(Long id) {
        if(!contains(id)) {
            throw new PriceNotFoundException("price not found = " + id);
        }
    }

    private boolean contains(Long id) {
        boolean isContain = priceMap.containsKey(id);
        if(!isContain) {
            log.warn("price not found for product id = {}", id);
        }

        return isContain;
    }
}
