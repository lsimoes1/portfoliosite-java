package com.portfoliosite.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.portfoliosite.model.Github;
import com.portfoliosite.service.abs.GithubInterface;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/github")
public class GithubController {

    @Autowired
    private GithubInterface githubService;

    @GetMapping("/repository")
    public ResponseEntity<List<Github>> getRepository() throws JsonProcessingException {
        List<Github> githubResponse = this.githubService.getRepository();
        return ResponseEntity.ok(githubResponse);
    }
}
