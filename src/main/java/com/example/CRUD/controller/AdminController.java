package com.example.CRUD.controller;

import com.example.CRUD.model.Role;
import com.example.CRUD.model.User;
import com.example.CRUD.service.RoleService;
import com.example.CRUD.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;

    public AdminController(UserService userService, RoleService roleService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public String getUser(Model model, Authentication authentication) {
        model.addAttribute("userList", userService.getAllUsers());
        User user = (User) authentication.getPrincipal();
        model.addAttribute("user", user);

        model.addAttribute("roleList", roleService.getList());
        model.addAttribute("users", userService.showUser(user.getId()));

        return "admin";
    }

    @PostMapping("/newAddUserAdmin")
    public String saveNewUser(
            @ModelAttribute("user") User user
    ) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.createUser(user);
        return "redirect:/admin";
    }

    @DeleteMapping("{id}/delete")
    public String deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
        return "redirect:/admin";
    }


    @PutMapping("/{id}/editUser")
    public String userSaveEdit(@ModelAttribute("user") User user, @PathVariable("id") Long id) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.updateUser(user);
        return "redirect:/admin";
    }
}
