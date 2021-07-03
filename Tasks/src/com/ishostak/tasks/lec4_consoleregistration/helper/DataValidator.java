package com.ishostak.tasks.lec4_consoleregistration.helper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataValidator {

    public static final String FIRST_NAME_PATTERN = "^[A-Z][a-z]{2,}";
    public static final String LAST_NAME_PATTERN = "^[A-Z][a-z]{2,}";
    public static final String EMAIL_PATTERN = "a-z\\.?\\-?\\_?(a-z)?@a-z{2,}.a-z{2,}";
    public static final String NICKNAME_PATTERN ="^[A-Z][a-z]{6,}";
    public static final String SURNAME_PATTERN = "^[A-Z][a-z]{2,}";
    public static final String PHONE_NUMBER_PATTERN = "^[1-9][0-9]{9,10}";

    public static boolean isValid(String text, String rule) {
        Pattern pattern = Pattern.compile(rule);

        Matcher matcher = pattern.matcher(text);

        return matcher.matches();
    }
}
