package com.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@RestController
public class RequestController {
    @GetMapping("/client-ip")
    public String clientIp(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        log.info("X-FORWARDED-FOR : {}", ip);

        if (ip == null) {
            ip = request.getHeader("Proxy-Client-IP");
            log.info("Proxy-Client-IP : {}", ip);
        }
        if (ip == null) {
            ip = request.getHeader("WL-Proxy-Client-IP");
            log.info("WL-Proxy-Client-IP : {}", ip);
        }
        if (ip == null) {
            ip = request.getHeader("HTTP_CLIENT_IP");
            log.info("HTTP_CLIENT_IP : {}", ip);
        }
        if (ip == null) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
            log.info("HTTP_X_FORWARDED_FOR : {}", ip);
        }
        if (ip == null) {
            ip = request.getRemoteAddr();
            log.info("getRemoteAddr : {}", ip);
        }
        log.info("Result : IP Address : {}", ip);

        return ip;
    }

    @GetMapping("/hostname")
    public String hostName() throws UnknownHostException {
        return InetAddress.getLocalHost().getHostName();
    }

    @PostMapping("/hostname")
    public String postHostName() throws UnknownHostException {
        return InetAddress.getLocalHost().getHostName();
    }

    @PostMapping("/sleep/{max}")
    public String sleep(@PathVariable("max") Long max) throws InterruptedException {
        long randomSleep = ThreadLocalRandom.current().nextLong(max);
        Thread.sleep(randomSleep);

        return String.format("Sleep: %d", randomSleep);
    }
}
