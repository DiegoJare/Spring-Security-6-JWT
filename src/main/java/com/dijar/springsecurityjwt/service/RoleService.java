package com.dijar.springsecurityjwt.service;

import java.util.List;
import java.util.Optional;

import com.dijar.springsecurityjwt.entity.Role;


public interface RoleService {

    Role save(Role role);

    Role findByIdRole(Long id);

    Role update(Role role);

    void deleteByIdRole(Long id);

    List<Role> findAllRoles();

    Optional<Role> findByName(String name);

}
