package com.example.CRUD.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.CRUD.model.Role;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class RoleDaoImpl implements RoleDao {

    private EntityManager entityManager;

    public RoleDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public boolean add(Role role) {
        entityManager.persist(role);
        return true;
    }

    @Override
    public List<Role> getList() {
        return entityManager.createQuery("select s from Role s", Role.class).getResultList();
    }

    @Override
    public Role getRole(Long id) {
        return entityManager.find(Role.class, id);
    }

    @Override
    public void deleteRole(Long id) {
        entityManager.remove(getRole(id));
    }

    @Override
    public void editRole(Role role) {
        entityManager.merge(role);
    }

    @Override
    public List<Role> listByName(List<String> name) {
        return entityManager.createQuery("select u FROM Role u WHERe u.name in (:id)", Role.class)
                .setParameter("id", name)
                .getResultList();
    }

    @Override
    public Role findByName(String name) {
        return entityManager.createQuery("select u FROM Role u WHERe u.name = :id", Role.class)
                .setParameter("id", name)
                .getResultList().stream().findAny().orElse(null);
    }


}
