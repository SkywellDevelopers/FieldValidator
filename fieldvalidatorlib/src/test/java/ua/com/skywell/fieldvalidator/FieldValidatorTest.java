package ua.com.skywell.fieldvalidator;

import org.junit.Assert;
import org.junit.Test;

/**
 * For testing FieldValidator's methods behaviour.
 *
 * @author Constantine Chernenko.
 */
public class FieldValidatorTest {

    @Test
    public void isNameValidTest() {
        String[] validNames = FieldsDataFactory.generateValidNames();

        for (String name: validNames) {
            Assert.assertTrue(FieldValidator.isNameValid(name));
        }

        String[] invalidNames = FieldsDataFactory.generateInvalidNames();

        for (String name: invalidNames) {
            Assert.assertFalse(FieldValidator.isNameValid(name));
        }
    }

    @Test
    public void isCredentialsValidTest() {
        String[] validCredentials = FieldsDataFactory.generateValidCredentials();

        for (String credentials: validCredentials) {
            Assert.assertTrue(FieldValidator.isCredentialsValid(credentials));
        }

        String[] invalidCredentials = FieldsDataFactory.generateInvalidCredentials();

        for (String credentials: invalidCredentials) {
            Assert.assertFalse(FieldValidator.isCredentialsValid(credentials));
        }
    }

    @Test
    public void isUsernameValidTest() {
        String[] validUserNames = FieldsDataFactory.generateValidUserNames();

        for (String username: validUserNames) {
            Assert.assertTrue(FieldValidator.isUsernameValid(username));
        }

        String[] invalidUserNames = FieldsDataFactory.generateInvalidUserNames();

        for (String username: invalidUserNames) {
            Assert.assertFalse(FieldValidator.isUsernameValid(username));
        }
    }

    @Test
    public void isEmailValidTest() {
        String[] validEmails = FieldsDataFactory.generateValidEmails();

        for (String email: validEmails) {
            Assert.assertTrue(FieldValidator.isEmailValid(email));
        }

        String[] invalidEmails = FieldsDataFactory.generateInvalidEmails();

        for (String email: invalidEmails) {
            Assert.assertFalse(FieldValidator.isEmailValid(email));
        }
    }

    @Test
    public void isPasswordValidTest() {
        String[] validPasswords = FieldsDataFactory.generateValidPasswords();

        for (String password: validPasswords) {
            Assert.assertTrue(FieldValidator.isPasswordValid(password));
        }

        String[] invalidPasswords = FieldsDataFactory.generateInvalidPasswords();

        for (String password: invalidPasswords) {
            Assert.assertFalse(FieldValidator.isPasswordValid(password));
        }
    }

    @Test
    public void isCreditCardValidTest() {
        String[] validCreditCardNumbers = FieldsDataFactory.generateValidCreditCardNumbers();

        for (String creditCardNumber: validCreditCardNumbers) {
            Assert.assertTrue(FieldValidator.isCreditCardValid(creditCardNumber));
        }

        String[] invalidCreditCardNumbers = FieldsDataFactory.generateInvalidCreditCardNumbers();

        for (String creditCardNumber: invalidCreditCardNumbers) {
            Assert.assertFalse(FieldValidator.isCreditCardValid(creditCardNumber));
        }
    }

    @Test
    public void isNameValidEagerTest() {
        String[] validNames = FieldsDataFactory.generateValidNames();

        for (String name: validNames) {
            Assert.assertTrue(FieldValidator.isNameValidEager(name));
        }

        String[] invalidNames = FieldsDataFactory.generateInvalidEmptyNamesWithNulls();

        for (String name: invalidNames) {
            Assert.assertFalse(FieldValidator.isNameValidEager(name));
        }
    }

    @Test
    public void isCredentialsValidEagerTest() {
        String[] validCredentials = FieldsDataFactory.generateValidCredentials();

        for (String credentials: validCredentials) {
            Assert.assertTrue(FieldValidator.isCredentialsValidEager(credentials));
        }

        String[] invalidCredentials = FieldsDataFactory.generateInvalidEmptyCredentialsWithNulls();

        for (String credentials: invalidCredentials) {
            Assert.assertFalse(FieldValidator.isCredentialsValidEager(credentials));
        }
    }

    @Test
    public void isUsernameValidEagerTest() {
        String[] validUserNames = FieldsDataFactory.generateValidUserNames();

        for (String userName: validUserNames) {
            Assert.assertTrue(FieldValidator.isUsernameValidEager(userName));
        }

        String[] invalidUserNames = FieldsDataFactory.generateInvalidEmptyUserNamesWithNulls();

        for (String userName: invalidUserNames) {
            Assert.assertFalse(FieldValidator.isUsernameValidEager(userName));
        }
    }

    @Test
    public void isEmailValidEagerTest() {
        String[] validEmails = FieldsDataFactory.generateValidEmails();

        for (String email: validEmails) {
            Assert.assertTrue(FieldValidator.isEmailValidEager(email));
        }

        String[] invalidEmails = FieldsDataFactory.generateInvalidEmptyEmailsWithNulls();

        for (String email: invalidEmails) {
            Assert.assertFalse(FieldValidator.isEmailValidEager(email));
        }
    }

    @Test
    public void isPasswordValidEagerTest() {
        String[] validPasswords = FieldsDataFactory.generateValidPasswords();

        for (String password: validPasswords) {
            Assert.assertTrue(FieldValidator.isPasswordValidEager(password));
        }

        String[] invalidPasswords = FieldsDataFactory.generateInvalidEmptyPasswordsWithNulls();

        for (String password: invalidPasswords) {
            Assert.assertFalse(FieldValidator.isPasswordValidEager(password));
        }
    }

    @Test
    public void isCreditCardValidEagerTest() {
        String[] validCreditCardNumbers = FieldsDataFactory.generateValidCreditCardNumbers();

        for (String creditCardNumber: validCreditCardNumbers) {
            Assert.assertTrue(FieldValidator.isCreditCardValidEager(creditCardNumber));
        }

        String[] invalidCreditCardNumbers = FieldsDataFactory.generateInvalidEmptyCreditCardNumbersWithNulls();

        for (String creditCardNumber: invalidCreditCardNumbers) {
            Assert.assertFalse(FieldValidator.isCreditCardValidEager(creditCardNumber));
        }
    }
}