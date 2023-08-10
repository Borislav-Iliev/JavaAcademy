package com.example.onetomany.run;

import com.example.onetomany.model.entity.Course;
import com.example.onetomany.model.entity.Instructor;
import com.example.onetomany.model.entity.InstructorDetail;
import com.example.onetomany.model.entity.Review;
import com.example.onetomany.repository.CourseRepository;
import com.example.onetomany.repository.InstructorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final InstructorRepository instructorRepository;
    private final CourseRepository courseRepository;

    public CommandLineRunnerImpl(InstructorRepository instructorRepository, CourseRepository courseRepository) {
        this.instructorRepository = instructorRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        //createInstructorWithCourses();

        //findInstructorWithCourses(1L);

        //findCoursesForInstructor(1L);

        //findInstructorWithCoursesByInstructorIdJoinFetch(1L);

        //updateInstructor(1L);

        //updateCourse(1L);

        //deleteInstructor(1L);

        //deleteCourse(1L);
        //deleteCourse(2L);

        //createCourse();
        //findCourseAndReviews(1L);

        //deleteCourse(1L);
    }

    private void findCourseAndReviews(Long id) {
        Optional<Course> course = this.courseRepository.findCourseAndReviewsById(id);

        if (course.isEmpty()) {
            System.out.println("Couldn't find course with id: " + id);
            return;
        }

        System.out.println("Course with id: " + id);
        System.out.println(course.get());
        System.out.println("Reviews of the course: " + course.get().getReviews());
    }

    private void createCourse() {
        Course course = new Course("Course");

        Review review1 = new Review("Great course");
        Review review2 = new Review("Cool course");

        course.addReview(review1);
        course.addReview(review2);

        this.courseRepository.save(course);
    }

    private void deleteCourse(Long id) {
        this.courseRepository.deleteById(id);
    }

    private void deleteInstructor(Long id) {
        Instructor instructor = this.instructorRepository.findInstructorByInstructorId(id);

        List<Course> courses = instructor.getCourses();

        for (Course course : courses) {
            course.setInstructor(null);
        }

        this.instructorRepository.delete(instructor);
    }

    private void updateCourse(Long id) {
        Optional<Course> course = this.courseRepository.findById(id);

        if (course.isEmpty()) {
            System.out.println("Couldn't find course with id: " + id);
            return;
        }

        course.get().setTitle("Test");

        this.courseRepository.save(course.get());
    }

    private void updateInstructor(Long id) {
        Optional<Instructor> instructor = this.instructorRepository.findById(id);

        if (instructor.isEmpty()) {
            System.out.println("Couldn't find instructor with id: " + id);
            return;
        }

        instructor.get().setLastName("Test");

        this.instructorRepository.save(instructor.get());
    }

    private void findInstructorWithCoursesByInstructorIdJoinFetch(Long id) {
        Instructor instructor = this.instructorRepository.findInstructorByInstructorId(id);

        System.out.println("Instructor with id: " + id);
        System.out.println(instructor);
        System.out.println("Courses for the instructor: " + instructor.getCourses());
    }

    private void findCoursesForInstructor(Long instructorId) {
        Optional<Instructor> instructor = this.instructorRepository.findById(instructorId);

        if (instructor.isEmpty()) {
            System.out.println("Couldn't find instructor with id: " + instructorId);
            return;
        }

        List<Course> courses = this.courseRepository
                .findAllByInstructorId(instructorId);

        instructor.get().setCourses(courses);

        System.out.println("Instructor with id: " + instructorId);
        System.out.println(instructor.get());
        System.out.println("Courses for the instructor: " + courses);
    }

    private void findInstructorWithCourses(Long id) {
        Optional<Instructor> instructor = this.instructorRepository.findById(id);

        if (instructor.isEmpty()) {
            System.out.println("Couldn't find instructor with id: " + id);
            return;
        }

        System.out.println("Instructor with id: " + id);
        System.out.println(instructor.get());
        System.out.println("Courses of the instructor: " + instructor.get().getCourses());
    }

    private void createInstructorWithCourses() {
        Instructor instructor1 =
                new Instructor("Chad", "Darby", "darby@luv2code.com");

        InstructorDetail instructorDetail1 =
                new InstructorDetail("http://www.luv2code.com/youtube", "Luv 2 code!!!");

        instructor1.setInstructorDetail(instructorDetail1);

        Course course1 = new Course("Luv 2 code");
        Course course2 = new Course("Luv 2 code 2");

        instructor1.addCourse(course1);
        instructor1.addCourse(course2);

        this.instructorRepository.save(instructor1);
    }
}
