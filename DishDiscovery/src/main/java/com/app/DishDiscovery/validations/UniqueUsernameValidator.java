package com.app.DishDiscovery.validations;

import com.app.DishDiscovery.models.entities.UserEntity;
import com.app.DishDiscovery.repositories.UserRepository;
import com.app.DishDiscovery.validations.annotations.UniqueUsername;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {
    private final UserRepository userRepository;

    @Autowired
    public UniqueUsernameValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void initialize(UniqueUsername constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {
        UserEntity userEntity = userRepository.findByUsername(username);
        return userEntity == null;
    }
}
