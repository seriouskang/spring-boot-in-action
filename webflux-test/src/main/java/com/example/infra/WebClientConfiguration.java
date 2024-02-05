package com.example.infra;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ClientHttpConnector;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.netty.http.client.HttpClient;
import reactor.netty.resources.ConnectionProvider;

@Configuration
public class WebClientConfiguration {


    @Bean
    public WebClient webClient() {
        return WebClient.builder()
                .baseUrl(baseUrl())
                .clientConnector(reactorClientConnector())
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN_VALUE)
                .build();
    }

    private ClientHttpConnector reactorClientConnector() {
        return new ReactorClientHttpConnector(
                HttpClient.create(connectionProvider())
        );
    }

    private ConnectionProvider connectionProvider() {
        return ConnectionProvider.builder("testConnectionProvider")
                .maxConnections(10000)
                .pendingAcquireMaxCount(10000)
                .build();
    }

    private String baseUrl() {
        return UriComponentsBuilder.newInstance()
                .scheme("")
                .host("")
                .port(30080)
                .path("")
                .toUriString();
    }
}
