package com.app.DishDiscovery.repositories;

import com.app.DishDiscovery.models.entities.DifficultyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DifficultyRepository extends JpaRepository<DifficultyEntity, Long> {
}