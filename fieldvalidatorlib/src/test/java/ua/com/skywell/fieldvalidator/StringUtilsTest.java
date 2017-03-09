package ua.com.skywell.fieldvalidator;

import org.junit.Assert;
import org.junit.Test;

/**
 * For testing StringUtils methods behavior.
 *
 * @author Constantine Chernenko.
 */

public class StringUtilsTest {

    @Test
    @SuppressWarnings("ConstantConditions")
    public void isNotEmptyTest() {
        String emptyString = "";
        String nullString = null;

        Assert.assertFalse(StringUtils.isNotEmpty(emptyString));
        Assert.assertFalse(StringUtils.isNotEmpty(nullString));

        emptyString = "emptyString";
        nullString = "nullString";

        Assert.assertTrue(StringUtils.isNotEmpty(emptyString));
        Assert.assertTrue(StringUtils.isNotEmpty(nullString));
    }

    @Test
    @SuppressWarnings("ConstantConditions")
    public void isEmptyTest() {
        String emptyString = "";
        String nullString = null;

        Assert.assertTrue(StringUtils.isEmpty(emptyString));
        Assert.assertTrue(StringUtils.isEmpty(nullString));

        emptyString = "emptyString";
        nullString = "nullString";

        Assert.assertFalse(StringUtils.isEmpty(emptyString));
        Assert.assertFalse(StringUtils.isEmpty(nullString));
    }

    @Test
    public void isDigitsTest() {
        String[] validDigits = FieldsDataFactory.generateValidDigits();

        for (String digits: validDigits) {
            Assert.assertTrue(StringUtils.isDigits(digits));
        }

        String[] invalidDigits = FieldsDataFactory.generateInvalidDigits();

        for (String digits: invalidDigits) {
            Assert.assertFalse(StringUtils.isDigits(digits));
        }
    }

    @Test
    public void isDigitsWithAmountTest() {
        String[] validDigits = FieldsDataFactory.generateValidDigits();

        for (String digits: validDigits) {
            Assert.assertTrue(StringUtils.isDigits(digits, digits.length()));
        }

        //We should be certain that we checking that amount of digits >= 0
        Throwable exception = null;

        for (String digits: validDigits) {
            try {
                Assert.assertTrue(StringUtils.isDigits(digits, -digits.length()));
            } catch (IllegalArgumentException ex) {
                exception = ex;
            }

            Assert.assertTrue(exception != null);
        }

        String[] invalidDigits = FieldsDataFactory.generateInvalidDigits();

        for (String digits: invalidDigits) {
            Assert.assertFalse(StringUtils.isDigits(digits, digits.length()));
        }
    }

    @Test
    public void isDigitsEagerTest() {
        String[] validDigits = FieldsDataFactory.generateValidDigits();

        for (String digit: validDigits) {
            Assert.assertTrue(StringUtils.isDigitsEager(digit));
        }

        String[] invalidDigits = FieldsDataFactory.generateInvalidEmptyDigitsWithNulls();

        for (String digit: invalidDigits) {
            Assert.assertFalse(StringUtils.isDigitsEager(digit));
        }
    }

    @Test
    public void isDigitsEagerWithAmountTest() {
        String[] validDigits = FieldsDataFactory.generateValidDigits();

        for (String digits: validDigits) {
            Assert.assertTrue(StringUtils.isDigitsEager(digits, digits.length()));
        }

        String[] invalidDigits = FieldsDataFactory.generateInvalidEmptyDigitsWithNulls();

        //We should be certain that we checking that amount of digits >= 0
        Throwable exception = null;

        for (String digits: invalidDigits) {
            try {
                //Because of digits.length()
                if (digits != null) {
                    Assert.assertTrue(StringUtils.isDigitsEager(digits, -digits.length()));
                }
            } catch (IllegalArgumentException ex) {
                exception = ex;
            }

            Assert.assertTrue(exception != null);
        }

        for (String digits: invalidDigits) {
            //Because of digits.length()
            if (digits != null && digits.length() != 0) {
                Assert.assertFalse(StringUtils.isDigitsEager(digits, digits.length()));
            }
        }
    }
}