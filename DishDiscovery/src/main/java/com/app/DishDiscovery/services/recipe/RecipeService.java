package com.app.DishDiscovery.services.recipe;

import com.app.DishDiscovery.models.dtos.*;
import com.app.DishDiscovery.models.entities.RecipeEntity;

import java.util.List;

public interface RecipeService {
    void addRecipe(AddRecipeDTO addRecipeDTO);

    List<RecipeCardDTO> getAllRecipes();

    List<ShowCurrentUserRecipeCardDTO> getAllPersonalRecipes();

    void deleteRecipe(Long id);

    RecipeEntity getRecipeById(Long id);

    RecipeDTO convertToDTO(RecipeEntity recipeEntity);

    void addCommentToRecipe(Long recipeId, AddCommentDTO addCommentDTO);

    List<CommentDTO> getCurrentRecipeComments(Long id);
}
