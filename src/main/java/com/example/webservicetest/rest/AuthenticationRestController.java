package com.example.webservicetest.rest;

import com.example.webservicetest.dto.AuthenticationRequest;
import com.example.webservicetest.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "api/v1/auth/")
public class AuthenticationRestController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationRequest request) {
        return authenticationService.login(request);
    }

}
