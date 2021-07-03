package com.ishostak.tasks.lec4_consoleregistration.mvc;

import com.ishostak.tasks.lec4_consoleregistration.Helper.Message;

public class View {

    private final String REG_START = "Ro register enter your name: ";
    private final String REQUEST_LAST_NAME = "Enter last name: ";
    private final String REQUEST_EMAIL = "Enter email: ";
    private final String REQUEST_NICKNAME = "Enter nickname: ";
    private final String REQUEST_SURNAME = "Enter Surname: ";
    private final String REQUEST_PHONE_NUMBER = "Enter phone number: ";
    private final String INVALID_DATA = "Invalid data. Please, try again";

    public void printMessage(Message message) {
        System.out.println(message.getMessage());
    }

}
