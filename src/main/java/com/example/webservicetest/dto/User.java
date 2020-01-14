package com.example.webservicetest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;

}
