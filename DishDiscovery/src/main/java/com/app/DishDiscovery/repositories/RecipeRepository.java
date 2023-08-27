package com.app.DishDiscovery.repositories;

import com.app.DishDiscovery.models.entities.RecipeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<RecipeEntity, Long> {
    @Query("select r from RecipeEntity r")
    List<RecipeEntity> findAll();
}