package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Slf4j
@RestController
public class Controller {
    @GetMapping("/")
    public String root(@RequestParam(value = "name", defaultValue = "World") String name, @RequestHeader HttpHeaders headers) {
        log.error(headers.toString());
        log.error(String.format("Hello %s!!", name));
        log.debug("Debugging log");
        log.info("Info log");
        log.warn("Hey, This is a warning!");
        log.error("Oops! We have an Error. OK");
        return String.format("Hello %s!!", name);
    }

    @GetMapping("/io_task")
    public String io_task() throws InterruptedException {
        Thread.sleep(1000);
        log.info("io_task");
        return "io_task";
    }

    @GetMapping("/cpu_task")
    public String cpu_task() {
        for (int i = 0; i < 100; i++) {
            int tmp = i * i * i;
        }
        log.info("cpu_task");
        return "cpu_task";
    }

    @GetMapping("/random_sleep")
    public String random_sleep() throws InterruptedException {
        Thread.sleep((int) (Math.random() / 5 * 10000));
        log.info("random_sleep");
        return "random_sleep";
    }

    @GetMapping("/random_status")
    public String random_status(HttpServletResponse response) {
        List<Integer> givenList = Arrays.asList(200, 200, 300, 400, 500);
        Random rand = new Random();
        int randomElement = givenList.get(rand.nextInt(givenList.size()));
        response.setStatus(randomElement);
        log.info("random_status");
        return "random_status";
    }

    @GetMapping("/chain")
    public String chain() {
        String TARGET_ONE_HOST = System.getenv().getOrDefault("TARGET_ONE_HOST", "localhost");
        String TARGET_TWO_HOST = System.getenv().getOrDefault("TARGET_TWO_HOST", "localhost");
        log.debug("chain is starting");

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getForEntity("http://localhost:8080/", String.class);
        restTemplate.getForEntity(String.format("http://%s/io_task", TARGET_ONE_HOST), String.class);
        restTemplate.getForEntity(String.format("http://%s/cpu_task", TARGET_TWO_HOST), String.class);

        log.debug("chain is finished");
        return "chain";
    }

    @GetMapping("/error_test")
    public String error_test() throws Exception {
        throw new Exception("Error test");
    }
}