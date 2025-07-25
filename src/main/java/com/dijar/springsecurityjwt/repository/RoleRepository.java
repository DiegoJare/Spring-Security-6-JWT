package com.dijar.springsecurityjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dijar.springsecurityjwt.entity.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(String name);

}
