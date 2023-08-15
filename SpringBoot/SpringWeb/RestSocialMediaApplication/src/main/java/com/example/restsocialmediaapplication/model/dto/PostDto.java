package com.example.restsocialmediaapplication.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class PostDto {

    @NotBlank(message = "Description is required!")
    @Size(min = 5, max = 200, message = "Description must be between 5 and 200 characters!")
    private String description;

    public PostDto() {
    }

    public PostDto(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public PostDto setDescription(String description) {
        this.description = description;
        return this;
    }
}
