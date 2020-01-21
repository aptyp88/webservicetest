package com.example.webservicetest.rest;

import com.example.webservicetest.dto.User;
import com.example.webservicetest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/admin/")
public class AdminController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "find-user-by-id/{id}")
    public User findUserById(@PathVariable Long id) {
        return userService.findUserById(id);
    }

    @GetMapping(value = "find-all")
    public List<User> findAllUsers(Pageable pageable) {
        return userService.findAllUsers(pageable);
    }

}
