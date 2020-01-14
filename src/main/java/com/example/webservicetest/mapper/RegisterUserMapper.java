package com.example.webservicetest.mapper;

import com.example.webservicetest.domain.UserEntity;
import com.example.webservicetest.dto.UserRegisterRequest;
import com.example.webservicetest.service.UserService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = UserService.class)
public interface RegisterUserMapper {

    @Mappings({
            @Mapping(target = "updated", ignore = true),
            @Mapping(target = "status", ignore = true),
            @Mapping(target = "roles", ignore = true),
            @Mapping(target = "created", ignore = true),
            @Mapping(target = "id", ignore = true)
    })
    UserEntity mapToUserEntity(UserRegisterRequest request);
}
