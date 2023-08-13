package com.app.DishDiscovery.services.role;

import com.app.DishDiscovery.models.entities.RoleEntity;
import com.app.DishDiscovery.models.enums.RoleEnums;
import com.app.DishDiscovery.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void initRoles() {
        if (roleRepository.count() == 0) Arrays.stream(RoleEnums.values())
                .forEach(role_ -> {
                    RoleEntity role = new RoleEntity(role_);
                    roleRepository.save(role);
                });
    }
}
