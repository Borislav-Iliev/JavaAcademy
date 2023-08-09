package com.example.employeemvccrudexample.web;

import com.example.employeemvccrudexample.model.error.EmployeeNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ControllerExceptionHandling {

    @ExceptionHandler({EmployeeNotFoundException.class})
    public ModelAndView handleEmployeeNotFoundException(EmployeeNotFoundException ex) {
        ModelAndView modelAndView = new ModelAndView("employee-not-found");

        modelAndView.addObject("message", ex.getMessage());

        return modelAndView;
    }

    @ExceptionHandler({MethodArgumentTypeMismatchException.class})
    public ModelAndView handleTypeMismatchException(MethodArgumentTypeMismatchException ex) {
        ModelAndView modelAndView = new ModelAndView("employee-not-found");

        modelAndView.addObject("message", ex.getMessage());

        return modelAndView;
    }
}
