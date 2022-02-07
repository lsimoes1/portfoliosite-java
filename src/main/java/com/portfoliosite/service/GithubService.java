package com.portfoliosite.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.portfoliosite.model.Github;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class GithubService {

    private final RestTemplate restTemplate;

    @Value("${github.url}")
    private String url;

    public GithubService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public List<Github> getRepository() throws JsonProcessingException {
        String responseGitRepository = this.restTemplate.getForObject(this.url, String.class);
        //ObjectMapper mapper = new ObjectMapper();
        //var teste = mapper.readValue(responseGitRepository, List<Github.class>);

        ObjectMapper mapper = new ObjectMapper();
        ObjectReader reader = mapper.readerForListOf(Github.class);
        return reader.readValue(responseGitRepository);

    }
}
