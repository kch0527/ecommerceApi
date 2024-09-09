package com.example.userservice.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class ReqPwCheck {

    @NotNull(message = "userId cannot be null")
    @Size(min = 2, message = "userId not be less than two characters")
    @Email
    private String userId;

    @NotNull(message = "Password cannot be null")
    @Size(min = 8, message = "Password must be equals or grater than 8 characters")
    private String password;
}
