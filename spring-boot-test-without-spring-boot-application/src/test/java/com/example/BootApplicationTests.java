package com.example;

import com.example.application.SampleService;
import com.example.infrastructure.SampleRepositoryConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest(classes = SampleRepositoryConfiguration.class)
class BootApplicationTests {
    @Autowired
    SampleService sampleService;

    @Test
    void di_test() {
        assertThat(sampleService.findContentsById(1L))
                .isEqualTo("hello, 1");
    }
}
