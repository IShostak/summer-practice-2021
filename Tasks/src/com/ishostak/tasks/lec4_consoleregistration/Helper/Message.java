package com.ishostak.tasks.lec4_consoleregistration.Helper;

public enum Message {


    REG_START ("To register enter your name: "),
    REQUEST_LAST_NAME ("Enter last name: "),
    REQUEST_NICKNAME ("Enter nickname: "),
    REQUEST_EMAIL("Enter email: "),
    REQUEST_SURNAME ("Enter Surname: "),
    REQUEST_PHONE_NUMBER("Enter phone number: "),
    INVALID_DATA("Invalid data. Please, try again");

    private final String message;

    private Message(String s) {
        message = s;
    }

    public String getMessage() {
        return message;
    }
}
