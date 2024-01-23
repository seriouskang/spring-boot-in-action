package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Price {
    private long id;
    private double amount;
    private double discount;
}
