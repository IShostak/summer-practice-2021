package com.ishostak.tasks.lec4_consoleregistration.helper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataValidator {

    public static final String FIRST_NAME_PATTERN = "^[A-Z][a-z]{2,30}";
    public static final String LAST_NAME_PATTERN = "^[A-Z][a-z]{2,30}";
    public static final String EMAIL_PATTERN = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    public static final String NICKNAME_PATTERN ="^[a-z]{6,20}";
    public static final String SURNAME_PATTERN = "^[A-Z][a-z]{2,30}";
    public static final String PHONE_NUMBER_PATTERN = "^(\\+?[1-9])[0-9]{9,12}";

    public static boolean isValid(String text, String rule) {
        Pattern pattern = Pattern.compile(rule);

        Matcher matcher = pattern.matcher(text);

        return matcher.matches();
    }
}
