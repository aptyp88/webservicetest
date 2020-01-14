package com.example.webservicetest.mapper;

import com.example.webservicetest.domain.UserEntity;
import com.example.webservicetest.dto.User;
import com.example.webservicetest.service.UserService;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = UserService.class)
public interface UserMapper {

    User mapToUser(UserEntity userEntity);
}
