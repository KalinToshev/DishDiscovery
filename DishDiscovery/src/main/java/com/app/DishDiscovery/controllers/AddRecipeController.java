package com.app.DishDiscovery.controllers;

import com.app.DishDiscovery.models.dtos.AddRecipeDTO;
import com.app.DishDiscovery.services.recipe.RecipeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AddRecipeController {
    private final RecipeService recipeService;

    @Autowired
    public AddRecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/add-recipe")
    public String getAddRecipePage() {
        return "add-recipe";
    }

    @PostMapping("/add-recipe")
    public String addRecipe(@Valid AddRecipeDTO addRecipeDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("addRecipeDTO", addRecipeDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addRecipeDTO", bindingResult);
            return "redirect:/add-recipe";
        }

        recipeService.addRecipe(addRecipeDTO);

        return "redirect:/home";
    }

    @ModelAttribute
    public AddRecipeDTO addRecipeDTO() {
        return new AddRecipeDTO();
    }
}
