package com.springbootbackendvolunteering.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootbackendvolunteering.model.Role;

public interface RoleRepo extends JpaRepository<Role, Integer> {

}
