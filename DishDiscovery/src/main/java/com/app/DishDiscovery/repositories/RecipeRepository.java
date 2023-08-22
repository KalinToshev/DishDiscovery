package com.app.DishDiscovery.repositories;

import com.app.DishDiscovery.models.entities.RecipeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends JpaRepository<RecipeEntity, Long> {
}