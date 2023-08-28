package com.app.DishDiscovery.controllers;

import com.app.DishDiscovery.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfileController {
    private final UserService userService;

    @Autowired
    public ProfileController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/profile")
    public String getProfilePage(Model model) {
        model.addAttribute("currentUserInfo", userService.mapToShowCurrentUserInfoDTO());

        return "profile";
    }
}
