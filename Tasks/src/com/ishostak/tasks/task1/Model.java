package com.ishostak.tasks.task1;

public class Model {

    private String TEXT;
    public static final String WORD_ONE = "Hello";
    public static final String WORD_TWO = "World";

    public boolean isFirstValid(String text) {
        return text.equals(WORD_ONE);
    }

    public boolean isSecondValid(String text) {
        return text.equals(WORD_TWO);
    }

}
