package com.example.CRUD.service;

import com.example.CRUD.dao.*;
import com.example.CRUD.model.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleDaoImpl roleDaoImpl;

    public RoleServiceImpl(RoleDaoImpl roleDaoImpl) {
        this.roleDaoImpl = roleDaoImpl;
    }


    @Override
    @Transactional
    public boolean add(Role role) {
        roleDaoImpl.add(role);
        return true;
    }

    @Override
    public List<Role> getList() {
        return roleDaoImpl.getList();
    }

    @Override
    public Role getRole(Long id) {
        return roleDaoImpl.getRole(id);
    }

    @Override
    public void deleteRole(Long id) {
        roleDaoImpl.deleteRole(id);
    }

    @Override
    public void editRole(Role role) {
        roleDaoImpl.editRole(role);
    }

    @Override
    public List<Role> listByRole(List<String> name) {
        return roleDaoImpl.listByName(name);
    }
}