package com.example.onetomany.model.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "instructor")
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "instructor_detail_id", referencedColumnName = "id")
    private InstructorDetail instructorDetail;

    @OneToMany(mappedBy = "instructor",
            fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    private List<Course> courses;

    public Instructor() {
        this.courses = new ArrayList<>();
    }

    public Instructor(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.courses = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public Instructor setId(Long id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Instructor setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Instructor setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Instructor setEmail(String email) {
        this.email = email;
        return this;
    }

    public InstructorDetail getInstructorDetail() {
        return instructorDetail;
    }

    public Instructor setInstructorDetail(InstructorDetail instructorDetail) {
        this.instructorDetail = instructorDetail;
        return this;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public Instructor setCourses(List<Course> courses) {
        this.courses = courses;
        return this;
    }

    public void addCourse(Course course) {
        this.courses.add(course);

        course.setInstructor(this);
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", instructorDetail=" + instructorDetail +
                ", courses=" + courses +
                '}';
    }
}
