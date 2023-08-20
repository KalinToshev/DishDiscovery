package com.app.DishDiscovery.services.user;

import com.app.DishDiscovery.models.dtos.RegisterUserDTO;
import com.app.DishDiscovery.models.entities.UserEntity;

public interface UserService {
    void registerUser(RegisterUserDTO registerUserDTO);

    UserEntity getUserEntityByUsername(String username);
}
