package com.rouclec.securityjwt.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProtectedController {

    @GetMapping("/protected")
    public ResponseEntity<String> sayHelloUser(){
        return new ResponseEntity<>("Hello user", HttpStatus.OK);
    }
}
