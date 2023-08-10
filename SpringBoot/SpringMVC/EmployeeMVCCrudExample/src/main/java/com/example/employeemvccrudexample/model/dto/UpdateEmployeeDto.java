package com.example.employeemvccrudexample.model.dto;

import com.example.employeemvccrudexample.model.validation.UniqueEmail;
import jakarta.validation.constraints.Email;

public class UpdateEmployeeDto {
    private String firstName;

    private String lastName;

    @Email(message = "Email must be a valid email!")
    @UniqueEmail(message = "Email already taken!")
    private String email;

    public UpdateEmployeeDto() {
    }

    public String getFirstName() {
        return firstName;
    }

    public UpdateEmployeeDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UpdateEmployeeDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UpdateEmployeeDto setEmail(String email) {
        this.email = email;
        return this;
    }
}
