package com.example.restexample.error;

import java.time.LocalDateTime;

public class StudentErrorResponse {
    private int status;
    private String message;
    private LocalDateTime timeStamp;

    public StudentErrorResponse() {
    }

    public StudentErrorResponse(int status, String message, LocalDateTime timeStamp) {
        this.status = status;
        this.message = message;
        this.timeStamp = timeStamp;
    }

    public int getStatus() {
        return status;
    }

    public StudentErrorResponse setStatus(int status) {
        this.status = status;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public StudentErrorResponse setMessage(String message) {
        this.message = message;
        return this;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public StudentErrorResponse setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
        return this;
    }
}
