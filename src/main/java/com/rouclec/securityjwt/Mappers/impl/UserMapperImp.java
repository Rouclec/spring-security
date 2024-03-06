package com.rouclec.securityjwt.Mappers.impl;

import com.rouclec.securityjwt.Mappers.Mapper;
import com.rouclec.securityjwt.domain.dto.UserDto;
import com.rouclec.securityjwt.domain.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImp implements Mapper<User, UserDto> {

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDto mapTo(User user) {
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public User MapFrom(UserDto userDto) {
        return modelMapper.map(userDto, User.class);
    }
}
