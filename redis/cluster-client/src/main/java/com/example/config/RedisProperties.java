package com.example.config;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@Getter
@RequiredArgsConstructor
@ConfigurationProperties(prefix = "spring.data.redis.cluster")
public class RedisProperties {
    private final int maxRedirects;
    private final List<String> nodes;
}
