package com.rouclec.securityjwt.Mappers.impl;

import com.rouclec.securityjwt.Mappers.Mapper;
import com.rouclec.securityjwt.domain.dto.UserRequest;
import com.rouclec.securityjwt.domain.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImp implements Mapper<User, UserRequest> {

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserRequest mapTo(User user) {
        return modelMapper.map(user, UserRequest.class);
    }

    @Override
    public User MapFrom(UserRequest userDto) {
        return modelMapper.map(userDto, User.class);
    }
}
