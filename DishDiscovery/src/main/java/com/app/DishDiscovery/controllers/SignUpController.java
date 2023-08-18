package com.app.DishDiscovery.controllers;

import com.app.DishDiscovery.models.entities.UserEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignUpController {
    @GetMapping("/sign-up")
    public String getSignUpPage(Model model) {
        model.addAttribute("user", new UserEntity());

        return "sign-up";
    }

    @PostMapping("/sign-up")
    public String registerUser(@ModelAttribute UserEntity user) {
        return "redirect:/sign-in";
    }
}
