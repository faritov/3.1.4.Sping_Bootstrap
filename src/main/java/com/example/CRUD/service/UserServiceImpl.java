package com.example.CRUD.service;

import com.example.CRUD.dao.UserDaoImpl;
import com.example.CRUD.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {
    private final UserDaoImpl userDaoImpl;


    public UserServiceImpl(UserDaoImpl userDaoImpl) {
        this.userDaoImpl = userDaoImpl;
    }

    @Override
    public List<User> getAllUsers() {
        return userDaoImpl.getAllUsers();
    }

    @Override
    @Transactional
    public void createUser(User user) {
        userDaoImpl.createUser(user);
    }

    @Override
    @Transactional
    public void deleteUser(int id) {
        userDaoImpl.deleteUser(id);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        userDaoImpl.updateUser(user);
    }

    @Override
    public User showUser(int id) {
        return userDaoImpl.showUser(id);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = (User) userDaoImpl.getUser(username);
        user.getRoles().size();
        return user;
    }
}
