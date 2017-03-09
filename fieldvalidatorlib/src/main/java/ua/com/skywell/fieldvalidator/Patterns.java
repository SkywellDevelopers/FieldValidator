package ua.com.skywell.fieldvalidator;

/**
 * Contents all patterns.
 *
 * @author Constantine Chernenko.
 */
public class Patterns {

    private Patterns() {
        throw new IllegalStateException("No instances, please!");
    }

    /**
     * Regular expression for validation names or surnames in all (include international) formats.
     */
    public static final String NAME_OR_SURNAME_INTERNATIONAL =
            "^[^±!@£$%^&*_+§¡€#¢§¶•ªº«\\\\/<>?:;|=.,\\d\\s]{1,20}$";

    /**
     * Regular expression for validation user credentials (name and surname).
     */
    public static final String CREDENTIALS_INTERNATIONAL =
            "^[^±!@£$%^&*_+§¡€#¢§¶•ªº«\\\\/<>?:;|=.,\\d]{1,20}$";

    /**
     * Regular expression for validation usernames.
     */
    public static final String USERNAME =
            "^(?=.{4,20}$)(?![_.-])(?!.*[_.-]{2})[a-zA-Z0-9._@-]+(?<![_.-])$";

    /**
     * Regular expression for validation emails.
     */
    public static final String EMAIL =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    /**
     * Regular expression for validation passwords.
     */
    public static final String PASSWORD = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%!]).{6,20})";

    /**
     * Regular expression for checking if given string has digits only.
     */
    public static final String DIGITS_ONLY = "\\d+";

}