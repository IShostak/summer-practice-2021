package com.ishostak.tasks.lec1mvchelloworld;

public class Model {

    private String TEXT;
    public static final String WORD_ONE = "Hello";
    public static final String WORD_TWO = "World!";

    public boolean isFirstValid(String text) {
        return text.equals(WORD_ONE);
    }

    public boolean isSecondValid(String text) {
        return text.equals(WORD_TWO);
    }

    public String getTEXT() {
        return TEXT;
    }

    public void setTEXT(String TEXT) {
        this.TEXT = TEXT;
    }
}
