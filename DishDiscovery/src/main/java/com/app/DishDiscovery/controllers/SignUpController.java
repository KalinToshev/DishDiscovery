package com.app.DishDiscovery.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SignUpController {
    @GetMapping("/sign-up")
    public String getSignUpPage() {
        return "sign-up";
    }
}
