package com.app.DishDiscovery.controllers;

import com.app.DishDiscovery.models.dtos.AddRecipeDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AddRecipeController {
    @GetMapping("/add-recipe")
    public String getAddRecipePage() {
        return "add-recipe";
    }

    @PostMapping("/add-recipe")
    public String addRecipe() {
        return "add-recipe";
    }

    @ModelAttribute
    public AddRecipeDTO addRecipeDTO() {
        return new AddRecipeDTO();
    }
}
