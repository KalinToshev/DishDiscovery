package com.app.DishDiscovery.services.recipe;

import com.app.DishDiscovery.models.dtos.AddRecipeDTO;
import com.app.DishDiscovery.models.dtos.RecipeCardDTO;
import com.app.DishDiscovery.models.dtos.ShowCurrentUserRecipeCardDTO;
import com.app.DishDiscovery.models.entities.RecipeEntity;

import java.util.List;

public interface RecipeService {
    void addRecipe(AddRecipeDTO addRecipeDTO);

    List<RecipeCardDTO> getAllRecipes();

    List<ShowCurrentUserRecipeCardDTO> getAllPersonalRecipes();

    void deleteRecipe(Long id);
}
