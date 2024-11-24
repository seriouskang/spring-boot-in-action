package com.example.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ExampleController {
    @Value("${test.key1}")
    private String value1;

    @Value("${test.key2}")
    private String value2;

    @GetMapping("/value1")
    public String value1() {
        return value1;
    }

    @GetMapping("/value2")
    public String value2() {
        return value2;
    }
}
