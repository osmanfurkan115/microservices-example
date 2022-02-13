package io.github.osmanfurkan115.customer.validation.validator;

import io.github.osmanfurkan115.customer.validation.annotation.PhoneNumber;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneNumberValidator implements ConstraintValidator<PhoneNumber, String> {
    @Override
    public boolean isValid(String phoneNumber, ConstraintValidatorContext constraintValidatorContext) {
        return phoneNumber.matches("[0-9]+") && phoneNumber.length() == 11;
    }
}
