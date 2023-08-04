package com.example.crudsample.run;

import com.example.crudsample.entity.Student;
import com.example.crudsample.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final StudentRepository studentRepository;

    public CommandLineRunnerImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        //System.out.println("Hello World!");
        //createStudent();
        //createMultipleStudents();

        //readStudent();
        //readAllStudents();
        //readAllStudentsOrderedByLastName();
        //readAllStudentsWithLastName("Doe");

        //updateStudent();

        //deleteStudent(5L);
        //deleteAllStudents();
    }

    private void createStudent() {
        Student student = new Student("John", "Doe", "john.doe@love@code.com");

        this.studentRepository.save(student);

        System.out.println(student);
    }

    private void createMultipleStudents() {
        Student student1 = new Student("Paul", "Doe", "paul.doe@love@code.com");
        Student student2 = new Student("Mary", "Public", "mary.public@love@code.com");
        Student student3 = new Student("Bonita", "Applebum", "bonita.applebum@love@code.com");

        this.studentRepository.save(student1);
        this.studentRepository.save(student2);
        this.studentRepository.save(student3);
    }

    private void readStudent() {
        Student student = this.studentRepository.findById(3L);
        System.out.println(student);
    }

    private void readAllStudents() {
        List<Student> students = this.studentRepository.findAll();

        for (Student student : students) {
            System.out.println(student);
        }
    }

    private void readAllStudentsOrderedByLastName() {
        List<Student> students = this.studentRepository.findAllOrderByLastName();

        for (Student student : students) {
            System.out.println(student);
        }
    }

    private void readAllStudentsWithLastName(String lastName) {
        List<Student> students = this.studentRepository.findByLastName(lastName);

        for (Student student : students) {
            System.out.println(student);
        }
    }

    private void updateStudent() {
        Student student = this.studentRepository.findById(1L);

        student.setFirstName("John");

        this.studentRepository.update(student);

        System.out.println(student);
    }

    private void deleteStudent(Long id) {
        this.studentRepository.delete(id);
    }

    private void deleteAllStudents() {
        System.out.println(this.studentRepository.deleteAll());
    }
}
