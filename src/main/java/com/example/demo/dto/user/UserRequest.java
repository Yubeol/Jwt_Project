package com.example.demo.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {
    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @NotNull
    private Integer age;

    @Email
    private String email;

    @NotBlank
    private String city;
}
