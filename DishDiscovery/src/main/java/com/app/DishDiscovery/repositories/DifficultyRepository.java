package com.app.DishDiscovery.repositories;

import com.app.DishDiscovery.models.entities.DifficultyEntity;
import com.app.DishDiscovery.models.enums.DifficultyEnums;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DifficultyRepository extends JpaRepository<DifficultyEntity, Long> {
    DifficultyEntity findByDifficulty(DifficultyEnums difficulty);
}