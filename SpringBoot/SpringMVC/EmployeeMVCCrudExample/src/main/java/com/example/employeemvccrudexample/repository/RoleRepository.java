package com.example.employeemvccrudexample.repository;

import com.example.employeemvccrudexample.model.entity.Role;
import com.example.employeemvccrudexample.model.enums.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByRole(RoleEnum role);
}
