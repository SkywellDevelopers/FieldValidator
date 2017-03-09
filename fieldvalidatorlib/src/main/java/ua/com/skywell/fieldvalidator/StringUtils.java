package ua.com.skywell.fieldvalidator;

import java.util.Locale;

/**
 * Utils class that provides helper methods.
 *
 * @author Constantine Chernenko.
 */
public class StringUtils {

    /**
     * <p>Checks if given string is NOT null and NOT empty.</p>
     *
     * @param fieldToCheck field which need to be validated.
     * @return true if field is NOT null or NOT empty.
     */
    @SuppressWarnings("ConstantConditions")
    public static boolean isNotEmpty(final String fieldToCheck) {
        return fieldToCheck != null && !fieldToCheck.trim().isEmpty();
    }

    /**
     * <p>Checks if given string is null and empty.</p>
     *
     * @param fieldToCheck field which need to be validated.
     * @return true if field is null or empty.
     */
    @SuppressWarnings("ConstantConditions")
    public static boolean isEmpty(final String fieldToCheck) {
        return fieldToCheck == null || fieldToCheck.trim().isEmpty();
    }

    /**
     * <p>Checks if a string contains digits only. It could be useful for validating phone numbers.</p>
     *
     * @param string parameter that needs to be checked.
     * @return true if the string contains only digits, otherwise - false.
     */
    @SuppressWarnings("ConstantConditions")
    public static boolean isDigits(String string) {
        return string.trim().matches(Patterns.DIGITS_ONLY);
    }

    /**
     * <p>Checks if a string contains digits only. It could be useful for validating phone numbers.</p>
     *
     * @param string parameter that needs to be checked.
     * @param amount of digits that should be present in the string.
     * @return true if the string contains only digits with passed amount symbols, otherwise - false.
     */
    @SuppressWarnings("ConstantConditions")
    public static boolean isDigits(String string, int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("amount can't be <= 0!");
        } else {
            return string.trim().matches(String.format(Locale.getDefault(), "\\d{%1$d}", amount));
        }
    }

    /**
     * <p>Checks if a string contains digits only. It could be useful for validating phone numbers.</p>
     *
     * <p><b>Eager implementation</b> - method also will check if field is <b>null</b> or <b>empty</b>!</p>
     *
     * @param string parameter that needs to be checked. Could be null or empty.
     * @return true if the string contains only digits, otherwise - false.
     */
    @SuppressWarnings("ConstantConditions")
    public static boolean isDigitsEager(String string) {
        return StringUtils.isNotEmpty(string) && string.trim().matches(Patterns.DIGITS_ONLY);
    }

    /**
     * <p>Checks if a string contains digits only. It could be useful for validating phone numbers.</p>
     *
     * <p><b>Eager implementation</b> - method also will check if field is <b>null</b> or <b>empty</b>!</p>
     *
     * @param string parameter that needs to be checked. Could be null or empty.
     * @param amount of digits that should be present in the string.
     * @return true if the string contains only digits with passed amount symbols, otherwise - false.
     */
    @SuppressWarnings("ConstantConditions")
    public static boolean isDigitsEager(String string, int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("amount can't be <= 0!");
        } else {
            return StringUtils.isNotEmpty(string) &&
                    string.trim().matches(String.format(Locale.getDefault(), "\\d{%1$d}", amount));
        }
    }
}