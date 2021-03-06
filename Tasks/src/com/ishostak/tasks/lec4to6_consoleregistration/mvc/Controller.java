package com.ishostak.tasks.lec4to6_consoleregistration.mvc;

import com.ishostak.tasks.lec4to6_consoleregistration.helper.*;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Controller {

    private final String RESOURCE_BASE_PATH = "com/ishostak/tasks/lec4to6_consoleregistration/";
    private final String RESOURCE_BASE_NAME =  RESOURCE_BASE_PATH + "text";
    private final String PATTERN_BASE_NAME = RESOURCE_BASE_PATH + "pattern";

    private Model model;
    private View view;
    private Scanner scanner;
    private ResourceBundle bundle;
    private ResourceBundle patternBundle;

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

        chooseLang();

        view.printText(bundle.getString(Message.START.name()));

        firstName = requestData(Message.REQUEST_FIRST_NAME, PatternName.FIRST_NAME_PATTERN);
        lastName = requestData(Message.REQUEST_LAST_NAME, PatternName.LAST_NAME_PATTERN);
        surname = requestData(Message.REQUEST_SURNAME, PatternName.SURNAME_PATTERN);
        email = requestData(Message.REQUEST_EMAIL, PatternName.EMAIL_PATTERN);
        nickName = requestValidNickname();

        phoneNumber = requestData(Message.REQUEST_PHONE_NUMBER, PatternName.PHONE_NUMBER_PATTERN);

        newUser = new UserData.Builder()
                .withFirstName(firstName)
                .withLastName(lastName)
                .withEmail(email)
                .withNickName(nickName)
                .withSurName(surname)
                .withPhoneNumber(phoneNumber)
                .build();

        model.add(newUser);

        view.printText(bundle.getString(Message.REGISTRATION_COMPLETE.name()));
        view.printText(newUser.toString());
    }

    private void chooseLang() {
        view.printText("Choose language: \"en\" or \"ua\":");

        String lang = scanner.nextLine();

        while ( !(lang.equals("en") || lang.equals("ua"))) {
            view.printText("Invalid data. Try again");
            lang = scanner.nextLine();
        }

        bundle = ResourceBundle.getBundle(
                RESOURCE_BASE_NAME + "_" + lang,
                new Locale(lang, lang.toUpperCase()));

        patternBundle = ResourceBundle.getBundle(
                PATTERN_BASE_NAME + "_" + lang);
    }

    private String requestValidNickname() {
        String nickname;
        nickname = requestData(Message.REQUEST_NICKNAME.REQUEST_NICKNAME, PatternName.NICKNAME_PATTERN);

        while (model.isInvalidNickname(nickname)) {
            try {
                throw new UserAlreadyExistException("Try another nickname");
            } catch (UserAlreadyExistException e) {
                view.printText(e.toString());
                nickname = requestData(Message.REQUEST_NICKNAME, PatternName.NICKNAME_PATTERN);
            }
        }

        return nickname;
    }

    private String requestData(Message message, PatternName patternName) {
        view.printText(bundle.getString(message.name()));
        return getValidData(patternName.name());
    }

    private String getValidData(String patternName) {
        String result = scanner.nextLine();
        String pattern = patternBundle.getString(patternName);

        while (!DataValidator.isValid(result, pattern)) {
            view.printText(bundle.getString(Message.INVALID_DATA.name()));
            result = scanner.nextLine();
        }

        return result;
    }
}
