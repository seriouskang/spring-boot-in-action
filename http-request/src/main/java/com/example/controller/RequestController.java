package com.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Map;

@Slf4j
@RestController
public class RequestController {
    @GetMapping("/client-ip")
    public String clientIp(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        log.info("  > X-FORWARDED-FOR : {}", ip);

        if (ip == null) {
            ip = request.getHeader("Proxy-Client-IP");
            log.info("  > Proxy-Client-IP : {}", ip);
        }
        if (ip == null) {
            ip = request.getHeader("WL-Proxy-Client-IP");
            log.info("  > WL-Proxy-Client-IP : {}", ip);
        }
        if (ip == null) {
            ip = request.getHeader("HTTP_CLIENT_IP");
            log.info("  > HTTP_CLIENT_IP : {}", ip);
        }
        if (ip == null) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
            log.info("  > HTTP_X_FORWARDED_FOR : {}", ip);
        }
        if (ip == null) {
            ip = request.getRemoteAddr();
            log.info("  > getRemoteAddr : {}", ip);
        }
        log.info("Result : {}", ip);

        return ip;
    }

    @GetMapping("/headers")
    public Map<String, String> headers(@RequestHeader Map<String, String> headers) {
        log.info("headers = {}", headers);
        return headers;
    }

    @GetMapping("/hostname")
    public String hostName() throws UnknownHostException {
        return InetAddress.getLocalHost().getHostName();
    }

    @PostMapping("/hostname")
    public String postHostName() throws UnknownHostException {
        return InetAddress.getLocalHost().getHostName();
    }
}
