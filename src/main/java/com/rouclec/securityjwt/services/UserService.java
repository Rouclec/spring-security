package com.rouclec.securityjwt.services;

import com.rouclec.securityjwt.Mappers.impl.UserMapperImp;
import com.rouclec.securityjwt.domain.entity.User;
import com.rouclec.securityjwt.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapperImp userMapperImp;

    public List<User> getAll(){
        return StreamSupport.stream(userRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public User get(Long id) {
        User user = userRepository.findById(id).orElseThrow();
        return user;
    }
}
