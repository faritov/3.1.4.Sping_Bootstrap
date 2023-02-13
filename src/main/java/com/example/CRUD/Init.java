package com.example.CRUD;

import com.example.CRUD.model.Role;
import com.example.CRUD.model.User;
import com.example.CRUD.service.RoleService;
import com.example.CRUD.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class Init {



    private UserService userService;
    private RoleService roleService;

    public Init(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }


    //    @EventListener(ApplicationReadyEvent.class)
    @PostConstruct
    public void createTable () {
        if (roleService.getList().isEmpty()) {
            Role admin = new Role(1, "ROLE_ADMIN");
            Role user = new Role(2, "ROLE_USER");
            roleService.add(admin);
            roleService.add(user);
            List<Role> setRole = new ArrayList<>();
            setRole.add(admin);
            User newAdmin = new User("Alex", "Zer", 20,
                    "sea@yan.ru", "$2a$12$nNj251hCDwafhk/uGw2Wtehm7whW7QWOx6rdmxLKliLl5X8QbUSC.", setRole);

            userService.createUser(newAdmin);

        }
    }
}