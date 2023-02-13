package com.example.CRUD.service;

import com.example.CRUD.model.Role;

import java.util.List;

public interface RoleService {

    boolean add(Role role);

    List<Role> getList();

    Role getRole(Long id);

    void deleteRole(Long id);

    void editRole(Role role);

    List<Role> listByRole(List<String> name);
}
