package com.portfoliosite.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Github {
    @JsonAlias("name")
    private String NameProject;

    @JsonAlias("description")
    private String Description;

    @JsonAlias("updated_at")
    private String LastUpdate;

    @JsonAlias("language")
    private String Language;

    @JsonAlias("homepage")
    private String HomePage;

    @JsonAlias("html_url")
    private String UrlRepository;

}
