package io.github.osmanfurkan115.customer.validation;


import io.github.osmanfurkan115.customer.validation.validator.PhoneNumberValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


class PhoneNumberValidatorTest {
    private final PhoneNumberValidator validator = new PhoneNumberValidator();

    @Test
    public void isPhoneNumbersValid() {
        assertTrue(validator.isValid("05429412312", null));
        assertTrue(validator.isValid("02122408154", null));
        assertFalse(validator.isValid("054351", null));

    }
}
