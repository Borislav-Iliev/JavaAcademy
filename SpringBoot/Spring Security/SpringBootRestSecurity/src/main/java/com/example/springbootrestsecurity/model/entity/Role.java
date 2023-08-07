package com.example.springbootrestsecurity.model.entity;

import com.example.springbootrestsecurity.model.enums.RoleEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private RoleEnum role;

    public Role() {
    }

    public Role(RoleEnum role) {
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public Role setId(Long id) {
        this.id = id;
        return this;
    }

    public RoleEnum getRole() {
        return role;
    }

    public Role setRole(RoleEnum role) {
        this.role = role;
        return this;
    }
}
