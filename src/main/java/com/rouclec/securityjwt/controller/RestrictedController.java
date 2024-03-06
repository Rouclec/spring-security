package com.rouclec.securityjwt.controller;

import com.rouclec.securityjwt.Mappers.impl.UserMapperImp;
import com.rouclec.securityjwt.Mappers.impl.UserResponseMapper;
import com.rouclec.securityjwt.domain.dto.UserRequest;
import com.rouclec.securityjwt.domain.dto.UserResponse;
import com.rouclec.securityjwt.domain.entity.User;
import com.rouclec.securityjwt.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class RestrictedController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapperImp userMapper;

    @Autowired
    private UserResponseMapper userResponseMapper;

    @GetMapping("/restricted")
    public ResponseEntity<String> sayHelloAdmin(){
        return ResponseEntity.ok("Hello admin!");
    }

    @GetMapping("/users")
    public List<UserResponse> getAllUsers(){
        List<User> users = userService.getAll();
        return users.stream()
                .map(userResponseMapper::mapTo)
                .collect(Collectors.toList());
    }

    @GetMapping("/users/{id}")
    public UserResponse getUser(@PathVariable("id") Long id){
        return userResponseMapper.mapTo(userService.get(id));
    }
}
