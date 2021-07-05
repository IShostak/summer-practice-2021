package com.ishostak.tasks.lec4_consoleregistration.mvc;

import com.ishostak.tasks.lec4_consoleregistration.helper.DataValidator;
import com.ishostak.tasks.lec4_consoleregistration.helper.Message;
import com.ishostak.tasks.lec4_consoleregistration.helper.UserData;

import java.util.Scanner;

public class Controller {

    private Model model;
    private View view;
    private Scanner scanner;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        scanner = new Scanner(System.in);
    }

    public void startRegistration() {
        UserData newUser;

        String firstName;
        String lastName;
        String email;

        String nickName;
        String surname;
        String phoneNumber;

        view.printMessage(Message.START);

        firstName = requestData(Message.REQUEST_FIRST_NAME, DataValidator.FIRST_NAME_PATTERN);
        lastName = requestData(Message.REQUEST_LAST_NAME, DataValidator.LAST_NAME_PATTERN);
        surname = requestData(Message.REQUEST_SURNAME, DataValidator.SURNAME_PATTERN);
        email = requestData(Message.REQUEST_EMAIL, DataValidator.EMAIL_PATTERN);
        nickName = requestData(Message.REQUEST_NICKNAME, DataValidator.NICKNAME_PATTERN);
        phoneNumber = requestData(Message.REQUEST_PHONE_NUMBER, DataValidator.PHONE_NUMBER_PATTERN);

        newUser = new UserData.Builder()
                .withFirstName(firstName)
                .withLastName(lastName)
                .withEmail(email)
                .withNickName(nickName)
                .withSurName(surname)
                .withPhoneNumber(phoneNumber)
                .build();

        model.add(newUser);

        view.printMessage(Message.REGISTRATION_COMPLETE);
        view.printText(newUser.toString());
    }

    private String requestData(Message message, String pattern) {
        view.printMessage(message);
        return getValidData(pattern);
    }

    private String getValidData(String pattern) {
        String result = scanner.nextLine();

        while (!DataValidator.isValid(result, pattern)) {
            view.printMessage(Message.INVALID_DATA);
            result = scanner.nextLine();
        }

        return result;
    }
}
