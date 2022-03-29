package com.example.userservice.vo;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class RequestUser {

    @NotNull(message = "Eamil cannot be null")
    @Size(min=2,message = "Email not be less than 2 char")
    @Email
    private String email;

    @NotNull(message = "name cannot be null")
    @Size(min=2,message = "name not be less than 2 char")
    private String name;

    @NotNull(message = "pwd cannot be null")
    @Size(min=8,message = "pwd must be more than 8")
    private String pwd;
}
