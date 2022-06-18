package com.portfoliosite.service.abs;

import com.portfoliosite.model.Github;
import org.springframework.context.annotation.Bean;

import java.util.List;

public interface GithubInterface {
    public List<Github> getRepository();
}
