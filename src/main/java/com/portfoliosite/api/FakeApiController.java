package com.portfoliosite.api;

import com.portfoliosite.service.abs.FakeCredCardApiInterface;
import com.portfoliosite.service.impl.FakeCredCardApiImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/fakeapi")
public class FakeApiController {

    @Autowired
    private FakeCredCardApiInterface fakeApiService;

    @GetMapping("/{quantity}")
    public ResponseEntity<String> getCredCard(@PathVariable int quantity){
        return ResponseEntity.ok(this.fakeApiService.getCredCard(quantity));
    }
}
