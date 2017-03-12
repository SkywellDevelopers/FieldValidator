# FieldValidator

![](http://i.imgur.com/gApYZgg.png?1)  ![](http://i.imgur.com/1Q6ZYHk.png?1)

A small Android library for field validation. Methods that ends with **Eager**
will firstly check, if a passed String value is not Null or Empty, so we could write validation checks like:

```
if(FieldValidator.isNameValid(name)) {
    ...
} else {
    ...
}
```

Instead of:

```
if(!TextUtils.isEmpty(name)) {
    if(FieldValidator.isNameValid(name)) {
        ...
    } else {
        ...
    }
}
```

You could check examples of valid/not valid values in [tests](https://github.com/SkywellDevelopers/FieldValidator/blob/master/fieldvalidatorlib/src/test/java/ua/com/skywell/fieldvalidator/FieldsDataFactory.java).
Example of usage in the [sample](https://github.com/SkywellDevelopers/FieldValidator/blob/master/sample/src/main/java/ua/com/skywell/fieldvalidatorproject/MainActivity.java).

#### What you could validate:

1. Name/Middle name/Surname in <b>Unicode</b>. It will check if a passed String does not contain special characters (#,$,& and so on), numbers and/or whitespaces:

    **a)** Method **isNameValid(String value)**

    **b)** Method **isNameValidEager(String value)** - firstly it will check if a value is not **null** or **empty**, than - if it's valid.

2. Credentials in <b>Unicode</b> (if you need check Name + Surname as one field). It will check if a String does not contain special characters (#,$,& and so on) and/or numbers:

    **a)** Method **isCredentialsValid(String value)**

    **b)** Method **isCredentialsValidEager(String value)** - firstly it will check if a value is not **null** or **empty**, than - if it's valid.

3. Username/Nickname in <b>ASCII</b>. It will check if a String does not contain <b>some</b> special characters (#,&,* and so on) and that the passed value does not <b>starts</b> or <b>ends</b> with allowed special characters.

    **a)** Method **isUsernameValid(String value)**

    **b)** Method **isUsernameValidEager(String value)** - firstly it will check if a value is not **null** or **empty**, than - if it's valid.

4. Email in <b>ASCII</b>. It will check if a passed String does not contain special characters (#,$,& and so on) and contains <b>@</b> character with domain name.

    **a)** Method **isEmailValid(String value)**

    **b)** Method **isEmailValidEager(String value)** - firstly it will check if a value is not **null** or **empty**, than - if it's valid.

5. Password in <b>ASCII</b>. The password must follow next rules:

        1) Length is from 6 to 20 symbols;

        2) Minimum 1 upper case letter;

        3) Minimum 1 lower case letter;

        4) Minimum 1 digit;

        5) Minimum 1 special symbol (#,!,* - and so on);

    Methods:

     **a)** Method **isPasswordValid(String value)**

     **b)** Method **isPasswordValidEager(String value)** - firstly it will check if a value is not **null** or **empty**, than - if it's valid.

#### Luhn algorithm [see. Wikipedia](https://en.wikipedia.org/wiki/Luhn_algorithm):
    The Luhn algorithm is a simple checksum formula used to validate a variety of identification numbers, such as credit card numbers, IMEI numbers, National Provider Identifier numbers in the US, Canadian Social Insurance Numbers, and Greek Social Security Numbers (ΑΜΚΑ). It is not intended to be a cryptographically secure hash function; it was designed to protect against accidental errors, not malicious attacks. Most credit cards and many government identification numbers use the algorithm as a simple method of distinguishing valid numbers from mistyped or otherwise incorrect numbers.

6. Basic credit card validation:

     **a)** Method **isCreditCardValid(String value)**

     **b)** Method **isCreditCardValidEager(String value)** - firstly it will check if a value is not **null** or **empty**, than - if it's valid.

#### Helper methods to work with Strings:
 1. **isNotEmpty(String value)** - returns **true**, if a value is  **not null** and **not empty**.
 2. **isEmpty(String value)** - returns **true**, if a value is **null or empty**.
 3. **isDigits(String value)** - checks if a value contains only digits.
 4. **isDigits(String value, int amount)** - checks if a value contains only digits with specific amount, for example ("12345", 5) - returns **true**.
 5. **isDigitsEager(String value)** - the same as <b>#3</b> but, firstly it will check if a value is not **null** or **empty**, than - if it's valid.
 6. **isDigitsEager(String value, int amount)** - the same as <b>#4</b> but, firstly it will check if a value is not **null** or **empty**, than - if it's valid.

#### Mobile numbers validation:

If you need such validation (country code + operator code + formatting). We would recommend you to use next libraries:

1. [libphonenumber](https://github.com/googlei18n/libphonenumber) - a big library from Google.
2. [libphonenumber-android](https://github.com/MichaelRocks/libphonenumber-android) - Google's **libphonenumber** port special for Android (shrank methods count).
3. [Phonematter](https://github.com/terrakok/Phonematter) - phone number checking and formatting from official Telegram Android application.

#### Download:

    compile "ua.com.skywell.fieldvalidator:FieldValidator:1.0.0"

## License

```
    Copyright 2016 Skywell LLC.

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
```