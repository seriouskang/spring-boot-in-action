package com.example.model;

import lombok.Getter;

@Getter
public class Product {
    private long id;
    private String name;
    private Price price;

    public Product(long id, String name) {
        this.id = id;
        this.name = name;
    }
}
