package com.example.employeemvccrudexample.model.dto;

import com.example.employeemvccrudexample.model.validation.UniqueEmail;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class AddEmployeeDto {

    @NotBlank(message = "First Name is required!")
    @Size(min = 2, max = 20, message = "First Name must be between 2 and 20 characters!")
    private String firstName;

    @NotBlank(message = "Lat Name is required!")
    @Size(min = 2, max = 20, message = "Last Name must be between 2 and 20 characters!")
    private String lastName;

    @NotBlank(message = "Email is required!")
    @Email(message = "Email must be a valid email!")
    @UniqueEmail(message = "Email already taken!")
    private String email;

    public AddEmployeeDto() {
    }

    public AddEmployeeDto(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public AddEmployeeDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public AddEmployeeDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public AddEmployeeDto setEmail(String email) {
        this.email = email;
        return this;
    }
}
