package com.example.CRUD.controller;

import com.example.CRUD.model.User;
import com.example.CRUD.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping()
@Controller
public class LoginController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public LoginController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/login")
    String login() {
        return "login";

    }

}