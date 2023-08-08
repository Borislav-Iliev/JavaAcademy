package com.example.springmvcvalidation.model;

import com.example.springmvcvalidation.model.validation.StartsWith;
import jakarta.validation.constraints.*;

public class Customer {

    @NotBlank(message = "First Name is required!")
    @Size(min = 2, max = 20, message = "First Name must be between 2 and 20 characters!")
    private String firstName;

    @NotBlank(message = "Last Name is required!")
    @Size(min = 2, max = 20, message = "Last Name must be between 2 and 20 characters!")
    private String lastName;

    @NotNull(message = "Age is required!")
    @Min(value = 0, message = "Age cannot be less than 0!")
    @Max(value = 100, message = "Age cannot be more than 100!")
    private Integer age;

    @NotBlank(message = "Post code is required!")
    @Pattern(regexp = "^[A-z0-9]{5}", message = "Postal code must contain exactly 5 characters or digits")
    private String postalCode;

    @NotBlank(message = "Course Code must be provided!")
    @StartsWith(value = "LUV", message = "Field must start with LUV!")
    private String courseCode;

    public Customer() {
    }

    public Customer(String firstName, String lastName, Integer age, String postalCode, String courseCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.postalCode = postalCode;
        this.courseCode = courseCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public Customer setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Customer setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public Customer setAge(Integer age) {
        this.age = age;
        return this;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public Customer setPostalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public Customer setCourseCode(String courseCode) {
        this.courseCode = courseCode;
        return this;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                " , age='" + age + '\'' +
                " , postalCode='" + postalCode + '\'' +
                " , courseCode='" + courseCode + '\'' +
                '}';
    }
}
