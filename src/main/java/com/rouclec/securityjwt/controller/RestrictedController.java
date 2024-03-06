package com.rouclec.securityjwt.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestrictedController {

    @GetMapping("/restricted")
    public ResponseEntity<String> sayHelloAdmin(){
        return ResponseEntity.ok("Hello admin!");
    }
}
