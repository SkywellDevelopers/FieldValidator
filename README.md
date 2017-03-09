# FieldValidator

![](http://i.imgur.com/gApYZgg.png?1)  ![](http://i.imgur.com/1Q6ZYHk.png?1)

Небольшая (пока что) библиотека для валидации полей. Хотелось бы собрать фидбек о юзабельности.
Использует проверенные регулярные выражения. Методы, которые оканчиваются на **Eager** для того, чтобы
не писать что-то вроде:

```
if(!TextUtils.isEmpty(name)) {
    if(FieldValidator.isNameValid(name)) {
        ...
    } else {
        ...
    }
}
```

А сразу:
```
if(FieldValidator.isNameValid(name)) {
    ...
} else {
    ...
}
```


Валидные и не валидные значения полей можно посмотреть в [тестах](https://bitbucket.org/kchernenko_sw/fieldvalidatorporject/src/581dabe36af0af6b2fba57f94e2c12c792b8a1d8/fieldvalidator/src/test/java/ua/com/skywell/fieldvalidator/FieldsDataFactory.java?at=master&fileviewer=file-view-default).
Пример использования [тут](https://bitbucket.org/kchernenko_sw/fieldvalidatorporject/src/581dabe36af0af6b2fba57f94e2c12c792b8a1d8/app/src/main/java/ua/com/skywell/fieldvalidatorproject/MainActivity.java?at=master&fileviewer=file-view-default#MainActivity.java-28).
Что можно провалидировать:

1. Имя/Отчество/Фамилию в юникоде. Исключает наличие специальных символов и цифр. Для случаев, когда это отдельные поля:

    **a)** Метод **isNameValid(String string)**

    **б)** Метод **isNameValidEager(String string)** - сначала проверит передаваемую строку на **null** и на **пустоту**, потом на валидность.

2. Credentials (грубо говоря ФИО) в юникоде. Исключает наличие специальных символов и цифр. Для случаев, когда, например, имя и фамилия - одно поле.
Отличается от первого варианта тем, что в первом варианте не может быть пробелов:

    **a)** Метод **isCredentialsValid(String string)**

    **б)** Метод **isCredentialsValidEager(String string)** - сначала проверит передаваемую строку на **null** и на **пустоту**, потом на валидность.

3. Username/Nickname (логин) пользователя в ASCII. Исключает использование некоторых специальных символов (#,&,* и т.д.), проверяет, чтобы логин не начинался и не заканчивался на разрешённые спец. символы:

    **a)** Метод **isUsernameValid(String string)**

    **б)** Метод **isUsernameValidEager(String string)** - сначала проверит передаваемую строку на **null** и на **пустоту**, потом на валидность.

4. Email пользователя в ASCII. Исключает использование спец. символов, проверяет правильность написания (присутствие знака @ и доменного имени и т.д.):

    **a)** Метод **isEmailValid(String string)**

    **б)** Метод **isEmailValidEager(String string)** - сначала проверит передаваемую строку на **null** и на **пустоту**, потом на валидность.

5. Пароль пользователя в ASCII. Накладывает следующие ограничения на пароль:

        1) Должен быть от 6 до 20 символов;

        2) Должен содержать минимум одну заглавную букву;

        3) Должен содержать минимум одну строчную букву;

        4) Должен содержать минимум одну цифру;

        5) Должен содержать минимум один спец. символ (#,!,* - и т.д.);

    Методы:

    **a)** Метод **isPasswordValid(String string)**

    **б)** Метод **isPasswordValidEager(String string)** - сначала проверит передаваемую строку на **null** и на **пустоту**, потом на валидность.

#### Алгоритм Луна [cм. Wikipedia](https://ru.wikipedia.org/wiki/%D0%90%D0%BB%D0%B3%D0%BE%D1%80%D0%B8%D1%82%D0%BC_%D0%9B%D1%83%D0%BD%D0%B0):
    Алгоритм Луна (англ. Luhn algorithm) — алгоритм вычисления контрольной цифры номера пластиковой карты в соответствии со стандартом ISO/IEC 7812. Не является криптографическим средством, а предназначен в первую очередь для выявления ошибок, вызванных непреднамеренным искажением данных (например, при ручном вводе номера карты, при приёме данных о номере социального страхования по телефону). Позволяет лишь с некоторой степенью достоверности судить об отсутствии ошибок в блоке цифр, но не даёт возможности нахождения и исправления обнаруженной неточности.

6. Проверка кредитных карт на первичную валидность:

     **a)** Метод **isCreditCardValid(String string)**

     **б)** Метод **isCreditCardValidEager(String string)** - сначала проверит передаваемую строку на **null** и на **пустоту**, потом на валидность.

 P.S.: можно добавить метод валидации номера соц. страхования.

#### Дополнительные методы работы со строками:
 1. **isNotEmpty(String string)** - вернёт **true**, если строка  **не null** и **не пустая**.
 2. **isEmpty(String string)** - вернёт **true**, если строка **null или пустая**.
 3. **isDigits(String string)** - проверяет содержатся ли в строке только цифры. Может быть полезным для первичной проверки номера телефона.
 4. **isDigits(String string, int amount)** - проверяет содержатся ли в строке только цифры с заданным количеством, например ("12345", 5) - вернёт **true**. Может быть полезным для первичной проверки номера телефона.
 5. **isDigitsEager(String string)** - то же самое, что и п. 3, только сначала проверит передаваемую строку на **null** и на **пустоту**, потом на валидность.
 6. **isDigitsEager(String string, int amount)** - то же самое, что и п. 4, только сначала проверит передаваемую строку на **null** и на **пустоту**, потом на валидность.

#### Валидация номеров:
Тема довольно нетривиальная, если нужна точная валидация (код страны + код оператора + форматирование). Я знаю несколько инструментов для решения такой задачи:

1. [libphonenumber](https://github.com/googlei18n/libphonenumber) - проект от Google. Есть версия для Java.
2. [libphonenumber-android](https://github.com/MichaelRocks/libphonenumber-android) - порт этой библиотеки специально под Android (урезанно количество методов).
3. [Phonematter](https://github.com/terrakok/Phonematter) - вырезанная реализация проверки и форматирования номеров с Telegram и обвёрнута в библиотеку.

## Лицензия

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