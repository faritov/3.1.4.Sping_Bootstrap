package com.example.CRUD.dao;

import com.example.CRUD.model.User;

import javax.persistence.*;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class UserDaoImpl implements UserDao {


    private EntityManager entityManager;

    public UserDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<User> getAllUsers() {
        return entityManager
                .createQuery("SELECT u FROM User u ", User.class).getResultList();
    }

    @Override
    public void createUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public void deleteUser(int id) {
        entityManager.remove(entityManager.contains(showUser(id)) ? showUser(id) : entityManager.merge(showUser(id)));
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public User showUser(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public UserDetails getUser(String username) {
        return entityManager.createQuery(
                        "SELECT u FROM User u WHERE u.name = :username", User.class).setParameter("username", username)
                .getSingleResult();
    }

}
