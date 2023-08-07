package com.example.restexample.web;

import com.example.restexample.dto.StudentDto;
import com.example.restexample.error.StudentErrorResponse;
import com.example.restexample.error.StudentNotFoundException;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    private List<StudentDto> students;

    @PostConstruct
    public void initStudents() {
        this.students = new ArrayList<>();

        this.students.add(new StudentDto("John", "Doe"));
        this.students.add(new StudentDto("Paul", "Doe"));
        this.students.add(new StudentDto("Mary", "Smith"));
    }

    @GetMapping("/students")
    public ResponseEntity<List<StudentDto>> getStudents() {
        return ResponseEntity.ok(this.students);
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<StudentDto> getStudent(@PathVariable Integer id) {

        if (id < 0 || id >= this.students.size()) {
            throw new StudentNotFoundException("Student not found for id: " + id);
        }

        return ResponseEntity.ok(this.students.get(id));
    }
}
