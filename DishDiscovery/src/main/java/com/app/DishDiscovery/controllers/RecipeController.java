package com.app.DishDiscovery.controllers;

import com.app.DishDiscovery.models.dtos.RecipeDTO;
import com.app.DishDiscovery.models.entities.RecipeEntity;
import com.app.DishDiscovery.services.recipe.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class RecipeController {
    private final RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/recipe/{id}")
    public String viewRecipe(@PathVariable Long id, Model model) {
        RecipeEntity recipeEntity = recipeService.getRecipeById(id);

        if (recipeEntity != null) {
            RecipeDTO recipeDTO = recipeService.convertToDTO(recipeEntity);
            model.addAttribute("recipe", recipeDTO);
        }

        return "recipe";
    }
}
