package com.example.CRUD.configs;

import com.example.CRUD.model.Role;
import org.springframework.core.convert.converter.Converter;

public class StringRoleConverter implements Converter<String, Role> {

    @Override
    public Role convert(String id) {
        Role role = new Role();
        role.setId(Integer.valueOf(id));
        return role;
    }
}
