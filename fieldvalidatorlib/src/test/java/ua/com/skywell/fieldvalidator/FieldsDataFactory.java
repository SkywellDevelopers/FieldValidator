package ua.com.skywell.fieldvalidator;

/**
 * Factory for generating arrays of string.
 *
 * @author Constantine Chernenko.
 */

class FieldsDataFactory {

    static String[] generateValidNames() {
        return new String[]{"John", "Иван", "François", "José", "Brasão", "عالي",
                "Koch-Mehrin", "O'Brian", "Müller", "阿丽娅", "Вікторія",
                "阿德里昂", "阿达尔维托", "กนกพร", "ชัยอนันต์", "GÖZDE"};
    }

    static String[] generateInvalidNames() {
        return new String[]{"Jake23", "Иван;5", "José Brasão", ".Вікторія",
                "Koch-Mehrin#", "Koch-Mehrin_Müller", "阿丽娅 กนกพร",
                "4Justin", "rC@1C", "^Rey", "*Вероника", "_Dan"};
    }

    static String[] generateValidCredentials() {
        return new String[]{"Jake Wharton", "José Brasão", "Петр Иванов", "François Hollande",
                "Silvana Koch-Mehrin", "Peter Müller", "阿卜德哈伊姆 阿隆", "阿塞维多 亚当", "李 军",
                "بد الولِي", "Леся Українка", "กนกพร ชัยอนันต์"};
    }

    static String[] generateInvalidCredentials() {
        return new String[]{".José Brasão", "#Jake Wharton", "Peter % Müller",
                "Silvana Koch&Mehrin", "阿卜德哈伊姆 + 阿隆", "Abd al Bari%",
                "$بد الولِي", "Леся _aka_ Українка Леся Українка", "/Martin Eden/", "Joseph**"};
    }

    static String[] generateValidUserNames() {
        return new String[]{"username", "username_6", "JakeWharton444", "chethaase_777",
                "Ivan32_1", "Silvana_Koch", "Alan_6_6_6", "The0ldM0nk", "ConsulTimeLord",
                "petrov", "c0nst", "D@rkLord", "tan_iel", "MaXxYOG", "chet-haase"};
    }

    static String[] generateInvalidUserNames() {
        return new String[]{"_jake", ".admin", "super__user", "max..power", "jake--wharton", "li",
                "t", "zak+", "petrov.", "__rick", "super_user_", "jakob__", "}{ackeR",
                "~WhitePower~", "亚当", "亚当```", "```亚当```", "بد الولِي", "-hiker-"};
    }

    static String[] generateValidEmails() {
        return new String[]{"myemail@mail.com", "myemail2@gmail.com", "my.email@yahoo.com",
                "my_email@gmail.com", "myemail.2@yandex.ru", "other+100@504.org",
                "super-100email@the-mail.com", "myemail1@mail.com.ua"};
    }

    static String[] generateInvalidEmails() {
        return new String[]{"myemail", "myemailg@.com.my", "myemail123@gmail.a", "myemail123@.com",
                "myemail123@.com.com", ".myemail@mail.com", "myemail()*@gmail.com", "myemail@%*.com",
                "myemail..2002@gmail.com", "mymail.@gmail.com", "mail@email@gmail.com",
                "mail@gmail.com.1a", "亚@mail.com"};
    }

    static String[] generateValidPasswords() {
        return new String[]{"myPassword1#", "Password%1", "Pa$$w0rd", "@sworD1", "passWord!1"};
    }

    static String[] generateInvalidPasswords() {
        return new String[]{"password", "Password", "password1", "Password1", "Pa$$word", "PASSWORD",
                "MyPassword1*", "12345", "بد الولِي", "亚当", "my password!"};
    }

    static String[] generateValidDigits() {
        return new String[]{"1234567890", "1123", "234443444444", "000000000000000000", "1", "01"};
    }

    static String[] generateInvalidDigits() {
        return new String[]{"Ex0548478474", "hi!", "somestring", "_$##$%^&&*!"};
    }

    static String[] generateInvalidEmptyNamesWithNulls() {
        return new String[]{"Jake23", "Иван;5", "José Brasão", ".Вікторія",
                "Koch-Mehrin#", "", "阿丽娅 กนกพร", null, "rC@1C", "^Rey", null, "_Dan"};
    }

    static String[] generateInvalidEmptyCredentialsWithNulls() {
        return new String[]{".José Brasão", "#Jake Wharton", null, "Silvana Koch&Mehrin",
                "阿卜德哈伊姆 + 阿隆", "", "$بد الولِي", "", "/Martin Eden/", null};
    }

    static String[] generateInvalidEmptyUserNamesWithNulls() {
        return new String[]{"_jake", ".admin", "", "max..power", "jake--wharton", "li", "", "zak+",
                "petrov.", null, "super_user_", "jakob__", "", "~WhitePower~", "亚当", "亚当```",
                null, "بد الولِي", null};
    }

    static String[] generateInvalidEmptyEmailsWithNulls() {
        return new String[]{"myemail", "myemailg@.com.my", "", "myemail123@.com", "", ".myemail@mail.com",
                null, "myemail@%*.com", "myemail..2002@gmail.com", null, "", "mail@gmail.com.1a", null};
    }

    static String[] generateInvalidEmptyPasswordsWithNulls() {
        return new String[]{"password", "", "password1", null, "Pa$$word", null, "", null,
                "بد الولِي", "亚当", ""};
    }

    static String[] generateInvalidEmptyDigitsWithNulls() {
        return new String[]{"1234567&", null, "", "45%6666+", "numbers"};
    }

    static String[] generateValidCreditCardNumbers() {
        return new String[]{"4716871490419265", "5499832989659696", "4532749768525181",
                "5357511485957983", "4716603326852744", "5245853829733696", "376679154096611",
                "5571005873899055", "373628758845165", "6011748015528514", "6011534110413285"};
    }

    static String[] generateInvalidCreditCardNumbers() {
        return new String[]{"6011534110413281", "4716871490419261", "4716603326852244",
                "5571005873899050", "373628758845162", "37362875884516", "0000000000000000001",
                "5357511485957981", "12345678901", "12123233646334344343444444443434545464464"};
    }

    static String[] generateInvalidEmptyCreditCardNumbersWithNulls() {
        return new String[]{"6011534110413281", "", "4716603326852244", null, "373628758845162",
                null, "", "5357511485957981", null, ""};
    }
}