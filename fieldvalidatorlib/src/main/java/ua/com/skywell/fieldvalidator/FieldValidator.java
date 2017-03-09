package ua.com.skywell.fieldvalidator;

/**
 * FieldValidator entry point.
 *
 * @author Constantine Chernenko.
 */
public class FieldValidator {

    /**
     * <p>Checks if single field like <b>Name</b> OR <b>Surname</b> OR <b>Middle name</b> is valid.</p>
     *
     * @param nameOrSurname string that represents user Name/Surname/Middle name.
     * @return true if valid, otherwise - false.
     */
    public static boolean isNameValid(String nameOrSurname) {
        return nameOrSurname.trim().matches(Patterns.NAME_OR_SURNAME_INTERNATIONAL);
    }

    /**
     * <p>Checks if a credentials (name + surname) are valid.</p>
     *
     * @param credentials credentials field.
     * @return true if valid, otherwise - false.
     */
    public static boolean isCredentialsValid(String credentials) {
        return credentials.matches(Patterns.CREDENTIALS_INTERNATIONAL);
    }

    /**
     * <p>Checks if a username is valid. Username has to be <b>min 4</b> and <b>max 20</b> symbols.</p>
     *
     * <p>Will accept values like: "username34", "username_2016","username-2016" ,"user3-4_name".</p>
     *
     * <p>Will reject values like this: "un","us@name","username123456789_-" </p>
     *
     * @param username representation of the username as a string.
     * @return true if valid, otherwise - false.
     */
    public static boolean isUsernameValid(String username) {
        return username.matches(Patterns.USERNAME);
    }

    /**
     * <p>Checks if an email is valid.</p>
     *
     * @param email string that represents email.
     * @return true if valid, otherwise - false.
     */
    public static boolean isEmailValid(String email) {
        return email.matches(Patterns.EMAIL);
    }

    /**
     * <p>Checks if a password is valid.</p>
     *
     * @param password string that represents password.
     * @return true if valid, otherwise - false.
     */
    public static boolean isPasswordValid(String password) {
        return password.matches(Patterns.PASSWORD);
    }

    /**
     * <p>Checks if a credit card number valid.</p>
     * <p>Credit number <b>should be 16 digits</b>.</p>
     * <p>You could check <b>VISA</b> or <b>MasterCard</b> credit card numbers for simple validation.</p>
     *
     * @param creditCardNumber string that represents credit card number.
     *
     * @see LuhnAlgorithm for more details.
     * @return true if valid, otherwise - false.
     */
    public static boolean isCreditCardValid(String creditCardNumber) {
        return LuhnAlgorithm.getInstance().isCodeValid(creditCardNumber);
    }

    /**
     * <p>Checks if single field like <b>Name</b> OR <b>Surname</b> OR <b>Middle name</b> is valid.</p>
     *
     * <p><b>Eager implementation</b> - method also will check if field is <b>null</b> or <b>empty</b>!</p>
     *
     * @param nameOrSurname string that represents user Name/Surname/Middle name. Could be null or empty.
     * @return true if valid, otherwise - false.
     */
    @SuppressWarnings("ConstantConditions")
    public static boolean isNameValidEager(String nameOrSurname) {
        return StringUtils.isNotEmpty(nameOrSurname) &&
                nameOrSurname.trim().matches(Patterns.NAME_OR_SURNAME_INTERNATIONAL);
    }

    /**
     * <p>Checks if a credentials (name + surname) are valid.</p>
     *
     * <p><b>Eager implementation</b> - method also will check if field is <b>null</b> or <b>empty</b>!</p>
     *
     * @param credentials credentials field. Could be null or empty.
     * @return true if valid, otherwise - false.
     */
    @SuppressWarnings("ConstantConditions")
    public static boolean isCredentialsValidEager(String credentials) {
        return StringUtils.isNotEmpty(credentials) && credentials.matches(Patterns.CREDENTIALS_INTERNATIONAL);
    }

    /**
     * <p>Checks if a username is valid. Username has to be <b>min 3</b> and <b>max 15</b> symbols.</p>
     *
     * <p>Will accept values like: "username34", "username_2016","username-2016" ,"user3-4_name".</p>
     *
     * <p>Will reject values like this: "un","us@name","username123456789_-" </p>
     *
     * <p><b>Eager implementation</b> - method also will check if field is <b>null</b> or <b>empty</b>!</p>
     *
     * @param username string. Could be null or empty.
     * @return true if valid, otherwise - false.
     */
    @SuppressWarnings("ConstantConditions")
    public static boolean isUsernameValidEager(String username) {
        return StringUtils.isNotEmpty(username) && username.matches(Patterns.USERNAME);
    }

    /**
     * <p>Checks if an email is valid.</p>
     *
     * <p><b>Eager implementation</b> - method also will check if field is <b>null</b> or <b>empty</b>!</p>
     *
     * @param email address string. Could be null or empty.
     * @return true if valid, otherwise - false.
     */
    @SuppressWarnings("ConstantConditions")
    public static boolean isEmailValidEager(String email) {
        return StringUtils.isNotEmpty(email) && email.matches(Patterns.EMAIL);
    }

    /**
     * <p>Checks if a password is valid.</p>
     *
     * <p><b>Eager implementation</b> - method also will check if field is <b>null</b> or <b>empty</b>!</p>
     *
     * @param password string. Could be null or empty.
     * @return true if valid, otherwise - false.
     */
    @SuppressWarnings("ConstantConditions")
    public static boolean isPasswordValidEager(String password) {
        return StringUtils.isNotEmpty(password) && password.matches(Patterns.PASSWORD);
    }

    /**
     * <p>Checks if a credit card number valid.</p>
     * <p>Credit number <b>should be 16 digits</b>.</p>
     * <p>You could check <b>VISA</b> or <b>MasterCard</b> credit card numbers for simple validation.</p>
     *
     * <p><b>Eager implementation</b> - method also will check if field is <b>null</b> or <b>empty</b>!</p>
     *
     * @param creditCardNumber string that represents credit card number. Could be null or empty.
     *
     * @see LuhnAlgorithm for more details.
     * @return true if valid, otherwise - false.
     */
    @SuppressWarnings("ConstantConditions")
    public static boolean isCreditCardValidEager(String creditCardNumber) {
        return StringUtils.isNotEmpty(creditCardNumber)
                && LuhnAlgorithm.getInstance().isCodeValid(creditCardNumber);
    }
}