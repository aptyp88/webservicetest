package com.example.webservicetest.service;

import com.example.webservicetest.entity.UserEntity;
import com.example.webservicetest.exception.NotFoundException;
import com.example.webservicetest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserEntity findUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found"));
    }

    public void createUser() {
        UserEntity userEntity = new UserEntity(null, "Test", "Test", "email@mail.com", "9782742871");
        userRepository.save(userEntity);
    }

}