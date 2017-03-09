package ua.com.skywell.fieldvalidator;

/**
 * <p>Implementation of <b>Luhn Algorithm</b> for <b>basic</b> validation things like credit cards,
 * social secure numbers and other important stuff.</p>
 *
 * <p>See <a href="https://en.wikipedia.org/wiki/Luhn_algorithm">Luhn algorithm on Wiki</a> for
 * more information.</p>
 *
 * @author Constantine Chernenko.
 */

public class LuhnAlgorithm {

    private static volatile LuhnAlgorithm instance;

    private LuhnAlgorithm() {
    }

    public static LuhnAlgorithm getInstance() {
        LuhnAlgorithm localInstance = instance;
        if (localInstance == null) {
            synchronized (LuhnAlgorithm.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new LuhnAlgorithm();
                }
            }
        }

        return localInstance;
    }

    public boolean isCodeValid(String codeToCheck) {
        // this only works if you are certain all input will be at least 10 characters
        int extraChars = codeToCheck.length() - 10;

        if (extraChars < 0) {
            throw new IllegalArgumentException("Number length must be at least 10 characters!");
        }

        int sum = 0;
        boolean alternate = false;

        for (int i = codeToCheck.length() - 1; i >= 0; i--) {
            int n = Integer.parseInt(codeToCheck.substring(i, i + 1));
            if (alternate) {
                n *= 2;
                if (n > 9) {
                    n = (n % 10) + 1;
                }
            }
            sum += n;
            alternate = !alternate;
        }
        return (sum % 10 == 0);
    }
}