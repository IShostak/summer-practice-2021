package com.ishostak.tasks.lec4_consoleregistration.helper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataValidator {

    public static final String FIRST_NAME_PATTERN = "FIRST_NAME_PATTERN";
    public static final String LAST_NAME_PATTERN = "LAST_NAME_PATTERN";
    public static final String EMAIL_PATTERN = "EMAIL_PATTERN";
    public static final String NICKNAME_PATTERN ="NICKNAME_PATTERN";
    public static final String SURNAME_PATTERN = "SURNAME_PATTERN";
    public static final String PHONE_NUMBER_PATTERN = "PHONE_NUMBER_PATTERN";

    public static boolean isValid(String text, String rule) {
        Pattern pattern = Pattern.compile(rule);

        Matcher matcher = pattern.matcher(text);

        return matcher.matches();
    }
}
