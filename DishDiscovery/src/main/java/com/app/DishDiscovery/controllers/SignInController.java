package com.app.DishDiscovery.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SignInController {
    @GetMapping("/sign-in")
    public String getSignInPage() {
        return "sign-in";
    }
}
