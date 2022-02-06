package com.portfoliosite.api;

import com.portfoliosite.service.FakeApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/fakeapi")
public class FakeApiController {

    @Autowired
    private FakeApiService fakeApiService;

    @GetMapping("/{quantity}")
    public ResponseEntity<String> getCredCard(@PathVariable String quantity){
        return ResponseEntity.ok(this.fakeApiService.getCredCard(quantity));
    }
}
