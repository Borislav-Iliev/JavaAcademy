package com.example.restsocialmediaapplication.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class UserDto {

    @NotBlank(message = "Name is required!")
    @Size(min = 2, max = 20, message = "Name must be between 2 and 20 characters!")
    private String name;

    @PastOrPresent(message = "Birth Date cannot be in the future!")
    private LocalDate birthDate;

    public UserDto() {
    }

    public UserDto(String name, LocalDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public UserDto setName(String name) {
        this.name = name;
        return this;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public UserDto setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        return this;
    }
}
