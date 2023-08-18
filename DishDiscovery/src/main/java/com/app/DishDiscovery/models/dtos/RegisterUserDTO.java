package com.app.DishDiscovery.models.dtos;

import jakarta.validation.constraints.NotNull;

public class RegisterUserDTO {
    @NotNull
    private String username;

    @NotNull
    private String password;

    @NotNull
    private String confirmPassword;

    @NotNull
    private String fullName;

    @NotNull
    private String email;
}
