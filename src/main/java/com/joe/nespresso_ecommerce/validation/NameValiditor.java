package com.joe.nespresso_ecommerce.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NameValiditor implements ConstraintValidator<Name, String>{

    @Override
    public boolean isValid(String name, ConstraintValidatorContext conntext) {
        Pattern pattern = Pattern.compile("[^a-z]", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(name);
        return !matcher.find();
    }

}
