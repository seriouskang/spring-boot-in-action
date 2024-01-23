package com.example.controller;

import com.example.model.Product;
import com.example.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductRepository productRepository;

    @GetMapping(path = "/{id}")
    public Product product(@PathVariable long id) {
        log.info("getting product and price details with product id = {}", id);
        Product product = productRepository.findProductById(id);

        return product;
    }
}
