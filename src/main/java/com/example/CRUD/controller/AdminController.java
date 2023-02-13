package com.example.CRUD.controller;

import com.example.CRUD.model.Role;
import com.example.CRUD.model.User;
import com.example.CRUD.service.RoleService;
import com.example.CRUD.service.UserService;
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

    @GetMapping()
    public String getAllUsers(Model model) {
        model.addAttribute("listOfUsers", userService.getAllUsers());
        return "allUsers";
    }
    @GetMapping("/new")
    public String getViewForNewUser(Model model) {
        model.addAttribute("user", new User());
        List<Role> roles = roleService.getList();
        model.addAttribute("roleList", roles);
        return "new";
    }
    @PostMapping()
    public String addUser(@ModelAttribute("user") User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.createUser(user);
        return "redirect:/admin";
    }

    @GetMapping("/{id}")
    public String showUser(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.showUser(id));
        model.addAttribute("roleList",roleService.getList());
        return "showUser";
    }

    @GetMapping("/{id}/edit")
    public String getViewForUpdateUser(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.showUser(id));
        model.addAttribute("roleList",roleService.getList());
        return "edit";
    }

    @PatchMapping("/{id}")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/admin";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
        return "redirect:/admin";
    }
}
