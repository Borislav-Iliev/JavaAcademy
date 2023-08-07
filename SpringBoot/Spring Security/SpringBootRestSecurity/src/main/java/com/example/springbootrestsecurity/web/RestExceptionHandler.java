package com.example.springbootrestsecurity.web;

import com.example.springbootrestsecurity.model.dto.ErrorDto;
import com.example.springbootrestsecurity.model.error.EmployeeNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.time.LocalDateTime;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler({EmployeeNotFoundException.class})
    public ResponseEntity<ErrorDto> handleEmployeeNotFoundException(EmployeeNotFoundException ex) {
        ErrorDto errorDto = new ErrorDto();

        errorDto.setStatus(HttpStatus.NOT_FOUND.value());
        errorDto.setMessage(ex.getMessage());
        errorDto.setTimeStamp(LocalDateTime.now());

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(errorDto);
    }

    @ExceptionHandler({MethodArgumentTypeMismatchException.class})
    public ResponseEntity<ErrorDto> handleTypeMismatchException(MethodArgumentTypeMismatchException ex) {
        ErrorDto errorDto = new ErrorDto();

        errorDto.setStatus(HttpStatus.BAD_REQUEST.value());
        errorDto.setMessage(ex.getMessage());
        errorDto.setTimeStamp(LocalDateTime.now());

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(errorDto);
    }
}
