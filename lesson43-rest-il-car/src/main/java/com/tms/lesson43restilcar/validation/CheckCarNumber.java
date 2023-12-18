package com.tms.lesson43restilcar.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CarNumberValidator.class)
public @interface CheckCarNumber {
    String message() default "must be filled and match a certain pattern";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
