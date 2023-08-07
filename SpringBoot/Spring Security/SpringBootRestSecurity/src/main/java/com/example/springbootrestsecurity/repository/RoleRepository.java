package com.example.springbootrestsecurity.repository;

import com.example.springbootrestsecurity.model.entity.Role;
import com.example.springbootrestsecurity.model.enums.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByRole(RoleEnum role);
}
