package com.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@RestController
@RequestMapping("/sleep")
public class SleepController {
    @PostMapping("/random/{origin}/{bound}")
    public String sleep(@PathVariable("origin") Long origin,
                        @PathVariable("bound") Long bound) throws InterruptedException {
        long sleepTime = ThreadLocalRandom.current().nextLong(origin, bound);
        log.info("sleep = {}", sleepTime);
        Thread.sleep(sleepTime);

        return String.format("Sleep = %d", sleepTime);
    }
}
