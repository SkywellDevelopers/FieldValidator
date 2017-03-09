package ua.com.skywell.fieldvalidator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * For testing Luhn Algorithm implementation.
 *
 * @author Constantine Chernenko.
 */
public class LuhnAlgorithmTest {

    private LuhnAlgorithm luhnAlgorithm;

    @Before
    public void setUp() {
        luhnAlgorithm = LuhnAlgorithm.getInstance();
    }

    @Test
    public void isCodeValidTest() {
        String[] validCreditCardNumbers = FieldsDataFactory.generateValidCreditCardNumbers();

        for (String creditCardNumber: validCreditCardNumbers) {
            Assert.assertTrue(luhnAlgorithm.isCodeValid(creditCardNumber));
        }

        String[] invalidCreditCardNumbers = FieldsDataFactory.generateInvalidCreditCardNumbers();

        for (String creditCardNumber: invalidCreditCardNumbers) {
            Assert.assertFalse(luhnAlgorithm.isCodeValid(creditCardNumber));
        }
    }
}