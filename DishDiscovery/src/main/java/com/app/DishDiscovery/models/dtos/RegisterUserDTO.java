package com.app.DishDiscovery.models.dtos;

import com.app.DishDiscovery.validations.annotations.UniqueEmail;
import com.app.DishDiscovery.validations.annotations.UniqueUsername;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static com.app.DishDiscovery.utils.UserValidationMessages.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterUserDTO {
    @NotBlank(message = USERNAME_NOT_BLANK_MESSAGE)
    @Size(min = 8, message = USERNAME_SIZE_MESSAGE)
    @Pattern(regexp = USERNAME_PATTERN, message = USERNAME_PATTERN_MESSAGE)
    @UniqueUsername
    private String username;

    @NotBlank(message = PASSWORD_NOT_BLANK_MESSAGE)
    @Size(min = 8, message = PASSWORD_SIZE_MESSAGE)
    @Pattern(regexp = PASSWORD_PATTERN, message = PASSWORD_PATTERN_MESSAGE)
    private String password;

    @NotBlank(message = CONFIRM_PASSWORD_NOT_BLANK_MESSAGE)
    @Size(min = 8, message = CONFIRM_PASSWORD_SIZE_MESSAGE)
    private String confirmPassword;

    @NotBlank(message = FULL_NAME_NOT_BLANK_MESSAGE)
    @Pattern(regexp = FULL_NAME_PATTERN, message = FULL_NAME_PATTERN_MESSAGE)
    private String fullName;

    @NotBlank(message = EMAIL_NOT_BLANK_MESSAGE)
    @Email(message = EMAIL_PATTERN_MESSAGE)
    @UniqueEmail
    private String email;
}
