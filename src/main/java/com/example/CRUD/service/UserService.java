package com.example.CRUD.service;

import com.example.CRUD.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public interface UserService extends UserDetailsService {

    List<User> getAllUsers();

    void createUser(User user);

    void deleteUser(int id);

    void updateUser(User user);

    User showUser(int id);
    UserDetails loadUserByUsername(String email) throws UsernameNotFoundException;
    User loadUserByUserEmail(String email)throws UsernameNotFoundException;
}
