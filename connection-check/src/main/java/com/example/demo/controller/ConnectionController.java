package com.example.demo.controller;

import com.example.demo.service.ConnectionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class ConnectionController {
    private final ConnectionService connectionService;

    @GetMapping("/check-port")
    public boolean root(@RequestParam(required = true) String host,
                       @RequestParam(required = true) int port) {
        log.info("host: {}, ip: {}", host, port);
        return connectionService.isPortOpen(host, port);
    }
}