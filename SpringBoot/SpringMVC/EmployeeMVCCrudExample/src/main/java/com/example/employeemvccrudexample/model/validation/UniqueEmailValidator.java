package com.example.employeemvccrudexample.model.validation;

import com.example.employeemvccrudexample.repository.EmployeeRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

    private final EmployeeRepository employeeRepository;

    public UniqueEmailValidator(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return this.employeeRepository.findByEmail(value).isEmpty();
    }
}
