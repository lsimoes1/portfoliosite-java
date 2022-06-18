package com.portfoliosite.model;

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
    @JsonProperty("name")
    private String NameProject;

    @JsonProperty("description")
    private String Description;

    @JsonProperty("updated_at")
    private String LastUpdate;

    @JsonProperty("language")
    private String Language;

    @JsonProperty("homepage")
    private String HomePage;

    @JsonProperty("html_url")
    private String UrlRepository;

}
