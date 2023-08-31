package com.app.DishDiscovery.services.user;

import com.app.DishDiscovery.models.dtos.RegisterUserDTO;
import com.app.DishDiscovery.models.dtos.ShowUserDataForProfilePageDTO;
import com.app.DishDiscovery.models.dtos.UpdateUserDataFromProfilePageDTO;
import com.app.DishDiscovery.models.entities.RoleEntity;
import com.app.DishDiscovery.models.entities.UserEntity;
import com.app.DishDiscovery.models.enums.RoleEnums;
import com.app.DishDiscovery.repositories.RoleRepository;
import com.app.DishDiscovery.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    private final ModelMapper modelMapper;

    private final PasswordEncoder passwordEncoder;

    private final RoleRepository roleRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    @Override
    public void registerUser(RegisterUserDTO registerUserDTO) {
        UserEntity userEntity = new UserEntity();

        modelMapper.map(registerUserDTO, userEntity);

        userEntity.setPassword(passwordEncoder.encode(registerUserDTO.getPassword()));

        RoleEntity userRole = roleRepository.findByRole(RoleEnums.USER);
        RoleEntity adminRole = roleRepository.findByRole(RoleEnums.ADMINISTRATOR);

        if (userRepository.count() == 0) {
            userEntity.addRole(userRole);
            userEntity.addRole(adminRole);
        } else {
            userEntity.addRole(userRole);
        }

        userRepository.save(userEntity);
    }

    @Override
    public UserEntity getUserEntityByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public ShowUserDataForProfilePageDTO showUserInfoForProfilePage() {
        ShowUserDataForProfilePageDTO showUserDataForProfilePageDTO = new ShowUserDataForProfilePageDTO();

        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        UserEntity userEntityByUsername = getUserEntityByUsername(username);

        modelMapper.map(userEntityByUsername, showUserDataForProfilePageDTO);

        return showUserDataForProfilePageDTO;
    }

    @Override
    public void updateUser(UpdateUserDataFromProfilePageDTO updateUserDataFromProfilePageDTO) {
        UserEntity userEntityByUsername = getUserEntityByUsername(updateUserDataFromProfilePageDTO.getUsername());

        userEntityByUsername.setFullName(updateUserDataFromProfilePageDTO.getFullName());
        userEntityByUsername.setEmail(updateUserDataFromProfilePageDTO.getEmail());

        userRepository.save(userEntityByUsername);
    }
}
