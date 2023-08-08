package com.example.springmvcvalidation.model.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class StartsWithValidator implements ConstraintValidator<StartsWith, String> {

    private String prefix;

    @Override
    public void initialize(StartsWith constraintAnnotation) {
        this.prefix = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if (value == null) {
            return false;
        }

        return value.startsWith(this.prefix);
    }
}
