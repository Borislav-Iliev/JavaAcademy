package com.example.manytomany.run;

import com.example.manytomany.model.entity.Course;
import com.example.manytomany.model.entity.Student;
import com.example.manytomany.repository.CourseRepository;
import com.example.manytomany.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;

    public CommandLineRunnerImpl(CourseRepository courseRepository, StudentRepository studentRepository) {
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        //createCourseAndStudents();

        //findCourseAndStudentsByCourseId(1L);

        //findStudentAndCoursesByStudentId(1L);

        //addCoursesToStudent(1L);

        //deleteCourse(1L);

        //deleteStudent(1L);
    }

    private void deleteStudent(Long id) {
        this.studentRepository.deleteById(id);
    }

    private void deleteCourse(Long id) {
        this.courseRepository.deleteById(id);
    }

    private void addCoursesToStudent(Long id) {
        Optional<Student> student = this.studentRepository.findStudentAndCoursesById(id);

        if (student.isEmpty()) {
            System.out.println("Couldn't find student with id: " + id);
            return;
        }

        Course course1 = new Course("Course 2.1");
        Course course2 = new Course("Course 3.1");

        student.get().addCourse(course1);
        student.get().addCourse(course2);

        this.studentRepository.save(student.get());
    }

    private void findStudentAndCoursesByStudentId(Long id) {
        Optional<Student> student = this.studentRepository.findStudentAndCoursesById(id);

        if (student.isEmpty()) {
            System.out.println("Couldn't find student with id: " + id);
            return;
        }

        System.out.println("Student with id: " + id);
        System.out.println(student.get());
        System.out.println("Courses of student: " + student.get().getCourses());
    }

    private void findCourseAndStudentsByCourseId(Long id) {
        Optional<Course> course = this.courseRepository.findCourseAndStudentsById(id);

        if (course.isEmpty()) {
            System.out.println("Couldn't find course with id: " + id);
            return;
        }

        System.out.println("Course with id: " + id);
        System.out.println(course.get());
        System.out.println("Students in course: " + course.get().getStudents());
    }

    private void createCourseAndStudents() {
        Course course = new Course("Course");

        Student student1 = new Student("John", "Doe", "john@luv2code.com");
        Student student2 = new Student("Mary", "Public", "mary@luv2code.com");

        course.addStudent(student1);
        course.addStudent(student2);

        this.courseRepository.save(course);
    }
}
