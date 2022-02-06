package com.portfoliosite.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    private final RestTemplate restTemplate;

    @Value("${weather.accesskey}")
    private String accessKey;

    @Value("${weather.baseUrl}")
    private String url;

    public WeatherService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public String getWeatherCity(String city) throws Exception {
    String url = String.format("%s/current?access_key={1}&query={2}", this.url);
    return this.restTemplate.getForObject(url, String.class, this.accessKey, city);
    }
}
