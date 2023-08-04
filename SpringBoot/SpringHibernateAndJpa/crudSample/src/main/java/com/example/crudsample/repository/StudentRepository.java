package com.example.crudsample.repository;

import com.example.crudsample.entity.Student;

import java.util.List;

public interface StudentRepository {
    void save(Student student);

    Student findById(Long id);

    List<Student> findAll();

    List<Student> findAllOrderByLastName();

    List<Student> findByLastName(String lastName);

    void update(Student student);

    void delete(Long id);

    long deleteAll();
}
