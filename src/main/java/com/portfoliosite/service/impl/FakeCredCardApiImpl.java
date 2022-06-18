package com.portfoliosite.service.impl;

import com.google.common.base.Strings;
import com.portfoliosite.configuration.exception.CustomExceptionHandler;
import com.portfoliosite.service.abs.FakeCredCardApiInterface;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FakeCredCardApiImpl implements FakeCredCardApiInterface {

    private final RestTemplate restTemplate;

    @Value("${fakeapi.credcard.baseUrl}")
    private String credCardUrl;

    public FakeCredCardApiImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public String getCredCard(int quantity){
        String responseFakeCredCard = this.restTemplate
                .getForObject(this.credCardUrl, String.class, quantity);

        if(Strings.isNullOrEmpty(responseFakeCredCard))
            throw new CustomExceptionHandler("Nenhum dado encontrado.", HttpStatus.NOT_FOUND);

        return responseFakeCredCard;
    }
}
