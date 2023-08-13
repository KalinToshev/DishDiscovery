package com.app.DishDiscovery.repositories;

import com.app.DishDiscovery.models.entities.RoleEntity;
import com.app.DishDiscovery.models.enums.RoleEnums;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
    RoleEntity findByRole(RoleEnums roleEnum);
}