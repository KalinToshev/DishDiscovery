package com.app.DishDiscovery.controllers;

import com.app.DishDiscovery.models.dtos.RegisterUserDTO;
import com.app.DishDiscovery.models.entities.UserEntity;
import com.app.DishDiscovery.services.user.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SignUpController {
    private final UserService userService;

    @Autowired
    public SignUpController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/sign-up")
    public String getSignUpPage() {
        return "sign-up";
    }

    @PostMapping("/sign-up")
    public String registerUser(@Valid RegisterUserDTO registerUserDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        System.out.println();

        if (!registerUserDTO.getPassword().equals(registerUserDTO.getConfirmPassword())) {
            bindingResult.addError(
                    new FieldError(
                            "differentConfirmPassword",
                            "confirmPassword",
                            "Passwords must be the same!"
                    ));
        }

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("registerUserDTO", registerUserDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.registerUserDTO", bindingResult);
            return "redirect:/sign-up";
        }

        this.userService.registerUser(registerUserDTO);

        return "redirect:/sign-in";
    }

    @ModelAttribute
    public RegisterUserDTO registerUserDTO() {
        return new RegisterUserDTO();
    }
}
