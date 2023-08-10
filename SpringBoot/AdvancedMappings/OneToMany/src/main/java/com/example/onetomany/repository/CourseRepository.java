package com.example.onetomany.repository;

import com.example.onetomany.model.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findAllByInstructorId(Long instructorId);

    @Query("SELECT c FROM Course c JOIN FETCH c.reviews WHERE c.id = :courseId")
    Optional<Course> findCourseAndReviewsById(Long courseId);
}
