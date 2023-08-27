package com.app.DishDiscovery.services.recipe;

import com.app.DishDiscovery.models.dtos.AddRecipeDTO;
import com.app.DishDiscovery.models.dtos.RecipeCardDTO;

import java.util.List;

public interface RecipeService {
    void addRecipe(AddRecipeDTO addRecipeDTO);

    List<RecipeCardDTO> getAllRecipes();
}
