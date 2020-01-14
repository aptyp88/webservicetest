package com.example.webservicetest.rest;

import com.example.webservicetest.dto.User;
import com.example.webservicetest.dto.UserRegisterRequest;
import com.example.webservicetest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "api/v1/register")
public class RegisterController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User saveUser(@RequestBody @Valid UserRegisterRequest request) {
        return userService.register(request);
    }

}
