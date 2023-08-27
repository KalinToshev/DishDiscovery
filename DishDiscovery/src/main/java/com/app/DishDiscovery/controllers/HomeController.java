package com.app.DishDiscovery.controllers;

import com.app.DishDiscovery.models.dtos.RecipeCardDTO;
import com.app.DishDiscovery.services.recipe.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    private final RecipeService recipeService;

    @Autowired
    public HomeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/")
    public String getHomePage() {
        return "index";
    }

    @GetMapping("/home")
    public String getAuthenticatedHomePage(Model model) {
        List<RecipeCardDTO> allRecipes = recipeService.getAllRecipes();

        model.addAttribute("recipes", allRecipes);

        return "home";
    }
}
