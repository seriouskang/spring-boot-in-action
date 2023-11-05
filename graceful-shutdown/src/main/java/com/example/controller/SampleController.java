package com.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class SampleController {
    @GetMapping("/foo")
    public String foo() throws InterruptedException {
        log.info("get request");
        bar();

        return "success";
    }

    private void bar() throws InterruptedException {
        Thread.sleep(60000);
        log.info("end bar method");
    }
}
