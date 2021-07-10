package com.ishostak.tasks.lec4_consoleregistration;

import com.ishostak.tasks.lec4_consoleregistration.helper.UserData;
import com.ishostak.tasks.lec4_consoleregistration.mvc.Controller;
import com.ishostak.tasks.lec4_consoleregistration.mvc.Model;
import com.ishostak.tasks.lec4_consoleregistration.mvc.View;

public class Main {

    public static void main(String[] args) {
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view);

        //Fill model with some UserData
        UserData user1 = new UserData.Builder()
                .withFirstName("User1")
                .withLastName("Last_Name1")
                .withEmail("user1@mail.com")
                .withNickName("user1nick")
                .withPhoneNumber("+123456789041")
                .withSurName("Surname")
                .build();

        UserData user2 = new UserData.Builder()
                .withFirstName("User2")
                .withLastName("Last_Name2")
                .withEmail("user2@mail.com")
                .withNickName("user2nick")
                .withPhoneNumber("+12346789041")
                .withSurName("Surname2")
                .build();

        model.add(user1);
        model.add(user2);


        controller.startRegistration();
    }
}
