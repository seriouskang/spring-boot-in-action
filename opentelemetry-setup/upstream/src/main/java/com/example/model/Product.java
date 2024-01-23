package com.example.model;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Product {
    private long id;
    private String name;
    @Setter
    private Price price;

    public Product(long id, String name) {
        this.id = id;
        this.name = name;
    }
}
