package com.portfoliosite.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FakeApiService {

    private final RestTemplate restTemplate;

    @Value("${fakeapi.credcard.baseUrl}")
    private String credCardUrl;

    public FakeApiService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public String getCredCard(String quantity){
        return this.restTemplate.getForObject(this.credCardUrl, String.class, quantity);
    }
}
