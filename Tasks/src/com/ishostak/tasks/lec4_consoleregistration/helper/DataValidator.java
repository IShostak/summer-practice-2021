package com.ishostak.tasks.lec4_consoleregistration.helper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataValidator {

    public static boolean isValid(String text, String rule) {
        Pattern pattern = Pattern.compile(rule);

        Matcher matcher = pattern.matcher(text);

        return matcher.matches();
    }
}
