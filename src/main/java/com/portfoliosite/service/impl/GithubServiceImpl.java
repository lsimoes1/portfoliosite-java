package com.portfoliosite.service.impl;

import com.portfoliosite.configuration.exception.CustomExceptionHandler;
import com.portfoliosite.model.Github;
import com.portfoliosite.service.abs.GithubInterface;
import com.portfoliosite.utils.JsonUtils;
import lombok.SneakyThrows;
import lombok.var;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class GithubServiceImpl implements GithubInterface {

    private final RestTemplate restTemplate;

    @Value("${github.url}")
    private String url;

    public GithubServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @SneakyThrows
    public List<Github> getRepository() {
        String responseGitRepository = this.restTemplate
                .getForObject(this.url, String.class);

        var jsonGithub = JsonUtils.JsonToObject(responseGitRepository, Github.class);

        if(jsonGithub == null)
            throw new CustomExceptionHandler("Nenhum objeto encontrado", HttpStatus.NOT_FOUND);

        return (List<Github>) jsonGithub;
    }
}
