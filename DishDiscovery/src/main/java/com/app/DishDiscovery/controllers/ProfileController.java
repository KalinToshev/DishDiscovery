package com.app.DishDiscovery.controllers;

import com.app.DishDiscovery.models.dtos.UpdateUserDataFromProfilePageDTO;
import com.app.DishDiscovery.services.recipe.RecipeService;
import com.app.DishDiscovery.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProfileController {
    private final UserService userService;

    private final RecipeService recipeService;

    @Autowired
    public ProfileController(UserService userService, RecipeService recipeService) {
        this.userService = userService;
        this.recipeService = recipeService;
    }

    @GetMapping("/profile")
    public String getProfilePage(Model model) {
        model.addAttribute("user", userService.showUserInfoForProfilePage());
        model.addAttribute("personalRecipes", recipeService.getAllPersonalRecipes());

        return "profile";
    }

    @PostMapping("/profile")
    public String updateUser(UpdateUserDataFromProfilePageDTO updateUserDataFromProfilePageDTO) {
        userService.updateUser(updateUserDataFromProfilePageDTO);

        return "redirect:/profile";
    }

    @PostMapping("/recipes/delete/{id}")
    public String deletePersonalRecipe(@PathVariable("id") Long id) {
        recipeService.deleteRecipe(id);

        return "redirect:/profile";
    }

    @ModelAttribute
    public UpdateUserDataFromProfilePageDTO updateUserDataFromProfilePageDTO() {
        return new UpdateUserDataFromProfilePageDTO();
    }
}
