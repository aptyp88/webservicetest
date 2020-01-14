package com.example.webservicetest.rest;

import com.example.webservicetest.dto.User;
import com.example.webservicetest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping(value = "api/v1/users/")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("user-info")
    public User findUserInfo(Principal principal) {
        return userService.findUserInfoByUsername(principal.getName());
    }

}
