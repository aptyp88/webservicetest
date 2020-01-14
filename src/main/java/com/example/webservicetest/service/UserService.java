package com.example.webservicetest.service;

import com.example.webservicetest.domain.Role;
import com.example.webservicetest.domain.Status;
import com.example.webservicetest.domain.UserEntity;
import com.example.webservicetest.dto.User;
import com.example.webservicetest.dto.UserRegisterRequest;
import com.example.webservicetest.exception.NotFoundException;
import com.example.webservicetest.exception.RegistrationException;
import com.example.webservicetest.mapper.RegisterUserMapper;
import com.example.webservicetest.mapper.UserMapper;
import com.example.webservicetest.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RegisterUserMapper registerUserMapper;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public User register(UserRegisterRequest request) {

        UserEntity userEntity = registerUserMapper.mapToUserEntity(request);

        if (userRepository.findByUsernameOrEmail(userEntity.getUsername(), userEntity.getEmail()).isPresent()) {
            throw new RegistrationException("User with the same username or email already exists");
        }

        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        userEntity.setRoles(Collections.singleton(Role.ROLE_USER));
        //userEntity.setRoles(Collections.singleton(Role.ROLE_ADMIN));
        userEntity.setStatus(Status.ACTIVE);

        UserEntity registeredUser = userRepository.save(userEntity);

        log.info("IN register - user: {} successfully registered", registeredUser);

        return userMapper.mapToUser(registeredUser);
    }

    public User findUserById(Long id) {
        return userRepository.findById(id).map(userMapper::mapToUser)
                .orElseThrow(() -> new NotFoundException("User not found"));
    }

    public UserEntity findByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new NotFoundException("User not found"));
    }

    public User findUserInfoByUsername(String username) {
        return userRepository.findByUsername(username).map(userMapper::mapToUser)
                .orElseThrow(() -> new NotFoundException("User not found"));
    }

    public User saveUser(UserEntity userEntity) {
        UserEntity user = userRepository.save(userEntity);
        return userMapper.mapToUser(user);
    }

    public List<User> findAllUsers(Pageable pageable) {
        return Optional.ofNullable(userRepository.findAll(pageable).getContent())
                .map(list -> list.stream()
                        .map(userMapper::mapToUser).collect(Collectors.toList()))
                .orElseThrow(() -> new NotFoundException("Users not found"));
    }

}
