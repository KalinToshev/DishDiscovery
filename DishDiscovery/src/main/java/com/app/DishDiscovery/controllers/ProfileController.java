package com.app.DishDiscovery.controllers;

import com.app.DishDiscovery.models.dtos.UpdateUserDataFromProfilePageDTO;
import com.app.DishDiscovery.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProfileController {
    private final UserService userService;

    @Autowired
    public ProfileController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/profile")
    public String getProfilePage(Model model) {
        model.addAttribute("user", userService.showUserInfoForProfilePage());

        return "profile";
    }

    @PostMapping("/profile")
    public String updateUser(UpdateUserDataFromProfilePageDTO updateUserDataFromProfilePageDTO) {
        userService.updateUser(updateUserDataFromProfilePageDTO);

        return "redirect:/profile";
    }

    @ModelAttribute
    public UpdateUserDataFromProfilePageDTO updateUserDataFromProfilePageDTO() {
        return new UpdateUserDataFromProfilePageDTO();
    }
}
