package com.example.controller;

import com.example.model.Price;
import com.example.repository.PriceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/price")
public class PriceController {
    private final PriceRepository priceRepository;

    @GetMapping(path = "/{id}")
    public Price price(@PathVariable long id) {
        log.info("get price details for product id = {}", id);
        return priceRepository.findPriceById(id);
    }
}
