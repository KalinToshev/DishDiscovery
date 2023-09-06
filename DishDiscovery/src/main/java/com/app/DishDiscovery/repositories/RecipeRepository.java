package com.app.DishDiscovery.repositories;

import com.app.DishDiscovery.models.entities.RecipeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RecipeRepository extends JpaRepository<RecipeEntity, Long> {
    List<RecipeEntity> findByAuthor_Id(Long id);

    @Override
    Optional<RecipeEntity> findById(Long id);

    @Query("select r from RecipeEntity r")
    List<RecipeEntity> findAll();
}