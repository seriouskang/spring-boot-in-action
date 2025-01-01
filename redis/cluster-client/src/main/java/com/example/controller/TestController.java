package com.example.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class TestController {
    private final RedisTemplate<String, String> redisTemplate;

    @GetMapping("/hello")
    public String hello() {
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        valueOperations.set("ttt1", "vvv1");

        return "world";
    }
}
