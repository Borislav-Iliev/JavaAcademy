package com.example.restsocialmediaapplication.model.dto;

import java.time.LocalDateTime;

public class ErrorDto {
    private int status;
    private String message;
    private LocalDateTime dateTime;

    public ErrorDto() {
    }

    public ErrorDto(int status, String message, LocalDateTime dateTime) {
        this.status = status;
        this.message = message;
        this.dateTime = dateTime;
    }

    public int getStatus() {
        return status;
    }

    public ErrorDto setStatus(int status) {
        this.status = status;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ErrorDto setMessage(String message) {
        this.message = message;
        return this;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public ErrorDto setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
        return this;
    }
}
