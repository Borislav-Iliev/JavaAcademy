package com.example.restsocialmediaapplication.web;

import com.example.restsocialmediaapplication.model.dto.ErrorDto;
import com.example.restsocialmediaapplication.model.error.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler({ObjectNotFoundException.class, MethodArgumentTypeMismatchException.class})
    public ResponseEntity<ErrorDto> handleInvalidPathVariableElementException(Exception ex) {
        ErrorDto errorDto = new ErrorDto();

        errorDto.setStatus(HttpStatus.BAD_REQUEST.value());
        errorDto.setMessage(ex.getMessage());
        errorDto.setDateTime(LocalDateTime.now());

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(errorDto);
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<List<ErrorDto>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        List<ErrorDto> errors = new ArrayList<>();

        ex.getBindingResult().getAllErrors().forEach(er -> {
            errors.add(new ErrorDto()
                    .setStatus(HttpStatus.BAD_REQUEST.value())
                    .setMessage(er.getDefaultMessage())
                    .setDateTime(LocalDateTime.now())
            );
        });

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(errors);
    }
}
