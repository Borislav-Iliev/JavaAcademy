package com.example.manytomany.repository;

import com.example.manytomany.model.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Long> {

    @Query("SELECT i FROM Instructor i " +
            "JOIN FETCH i.courses " +
            "JOIN FETCH i.instructorDetail " +
            "WHERE i.id = :instructorId")
    Instructor findInstructorByInstructorId(Long instructorId);
}
