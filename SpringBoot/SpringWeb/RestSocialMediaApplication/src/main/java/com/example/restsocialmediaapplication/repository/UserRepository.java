package com.example.restsocialmediaapplication.repository;

import com.example.restsocialmediaapplication.model.dto.UserDto;
import com.example.restsocialmediaapplication.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT new com.example.restsocialmediaapplication.model.dto.UserDto " +
            "(u.name, u.birthDate) " +
            "FROM User u")
    List<UserDto> getAllUsers();

    @Query("SELECT new com.example.restsocialmediaapplication.model.dto.UserDto " +
            "(u.name, u.birthDate) " +
            "FROM User u" +
            " WHERE u.id = :id")
    Optional<UserDto> getUserById(Long id);
}
