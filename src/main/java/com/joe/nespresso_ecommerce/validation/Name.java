package com.joe.nespresso_ecommerce.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy =  NameValiditor.class)
public @interface Name {

    String message() default "Invalid data";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
