package com.tms.lesson43restilcar.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CarNumberValidator implements ConstraintValidator<CheckCarNumber, String> {
    String regex = "\\d{4}\\s\\D{2}-\\d";

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isBlank()){
            return false;
        }
        if(!value.matches(regex)){
            return false;
        }
        return true;
    }
}
