package com.rouclec.securityjwt.Mappers.impl;

import com.rouclec.securityjwt.Mappers.Mapper;
import com.rouclec.securityjwt.domain.dto.UserResponse;
import com.rouclec.securityjwt.domain.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserResponseMapper implements Mapper<User, UserResponse> {
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public UserResponse mapTo(User user) {
        return modelMapper.map(user, UserResponse.class);
    }

    @Override
    public User MapFrom(UserResponse userResponse) {
        return modelMapper.map(userResponse, User.class);
    }
}
