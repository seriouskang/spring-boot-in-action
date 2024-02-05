package com.example.infra;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
@Slf4j
@RequiredArgsConstructor
public class WebClientAdapter {
    private final WebClient webClient;

    public String post() {
        return webClient.post()
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}
