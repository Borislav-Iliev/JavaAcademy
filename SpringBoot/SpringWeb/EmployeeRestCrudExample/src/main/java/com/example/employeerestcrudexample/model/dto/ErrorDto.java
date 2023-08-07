package com.example.employeerestcrudexample.model.dto;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class ErrorDto {

    private int status;

    private String message;

    private LocalDateTime timeStamp;

    public ErrorDto() {
    }

    public ErrorDto(int status, String message, LocalDateTime timeStamp) {
        this.status = status;
        this.message = message;
        this.timeStamp = timeStamp;
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

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public ErrorDto setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
        return this;
    }
}
