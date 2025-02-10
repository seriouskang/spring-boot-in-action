package com.example.demo.config;

import org.apache.commons.net.telnet.TelnetClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConnectionConfig {
    @Bean
    public TelnetClient telnetClient() {
        return new TelnetClient();
    }
}
