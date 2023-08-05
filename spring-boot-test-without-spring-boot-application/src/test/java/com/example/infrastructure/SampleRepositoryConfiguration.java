package com.example.infrastructure;

import com.example.domain.SampleRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.example")
public class SampleRepositoryConfiguration {
    @Bean
    public SampleRepository sampleRepository() {
        return id -> "hello, " + id;
    }
}
