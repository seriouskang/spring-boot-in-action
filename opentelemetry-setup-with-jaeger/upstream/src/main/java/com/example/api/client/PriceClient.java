package com.example.api.client;

import com.example.model.Price;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
@RequiredArgsConstructor
public class PriceClient {
    private final RestTemplate restTemplate;

    @Value("${priceClient.baseUrl:http://localhost:8080}")
    private String baseUrl;

    public Price price(long id) {
        log.info("fetching price details with product id = {}", id);
        String url = String.format("%s/price/%d", baseUrl, id);

        return restTemplate.getForEntity(url, Price.class)
                .getBody();
    }
}
