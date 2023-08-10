package com.example.manytomany.repository;

import com.example.manytomany.model.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("SELECT s FROM Student s JOIN FETCH s.courses WHERE s.id = :studentId")
    Optional<Student> findStudentAndCoursesById(Long studentId);
}
