package com.example;

import com.example.infra.WebClientAdapter;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
@SpringBootTest
class BootApplicationTests {
    @Autowired
    WebClientAdapter webClientAdapter;

    @Test
    void post() throws InterruptedException {
        int postCount = 1_000_000;
        ExecutorService executorService = Executors.newFixedThreadPool(32);
        CountDownLatch latch = new CountDownLatch(postCount);

        for(int i=0; i<postCount; i++) {
            int order = i;
            executorService.submit(() -> {
                try {
                    log.info("{} = {}", order, webClientAdapter.post());
                } catch(Exception e) {
                    e.printStackTrace();
                } finally {
                    latch.countDown();
                }
            });
        }

        latch.await();
    }
}
