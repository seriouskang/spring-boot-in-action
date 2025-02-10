package com.example.demo.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.net.telnet.TelnetClient;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Slf4j
@Service
@RequiredArgsConstructor
public class ConnectionService {
    private final TelnetClient telnetClient;

    public boolean isPortOpen(String host, int port) {
        try {
            telnetClient.connect(host, port);
            log.info("{}:{} is open", host, port);
            return true;
        } catch (IOException e) {
            log.warn("{}:{} is not open", host, port);
            return false;
        } finally {
            try { telnetClient.disconnect(); }
            catch (IOException e) { /* nothing to do */ }
        }
    }
}
