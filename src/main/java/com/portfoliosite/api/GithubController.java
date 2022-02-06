package com.portfoliosite.api;

import com.portfoliosite.service.GithubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/github")
public class GithubController {

    @Autowired
    private GithubService githubService;

    @GetMapping("/repository")
    public ResponseEntity<String> getRepository(){
        return ResponseEntity.ok(this.githubService.getRepository());
    }
}
