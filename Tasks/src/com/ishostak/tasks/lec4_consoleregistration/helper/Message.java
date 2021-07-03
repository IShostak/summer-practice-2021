package com.ishostak.tasks.lec4_consoleregistration.helper;

public enum Message {

    START("Hello. To register: "),
    REQUEST_FIRST_NAME("Enter you name: "),
    REQUEST_LAST_NAME ("Enter last name: "),
    REQUEST_NICKNAME ("Enter nickname: "),
    REQUEST_EMAIL("Enter email: "),
    REQUEST_SURNAME ("Enter Surname: "),
    REQUEST_PHONE_NUMBER("Enter phone number: "),
    REGISTRATION_COMPLETE("Congratulations! You successfully registered."),
    INVALID_DATA("Invalid data. Please, try again");

    private final String message;

    private Message(String s) {
        message = s;
    }

    public String getMessage() {
        return message;
    }
}
