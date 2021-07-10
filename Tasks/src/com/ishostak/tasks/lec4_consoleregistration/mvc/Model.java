package com.ishostak.tasks.lec4_consoleregistration.mvc;

import com.ishostak.tasks.lec4_consoleregistration.helper.UserAlreadyExistException;
import com.ishostak.tasks.lec4_consoleregistration.helper.UserData;

import java.util.ArrayList;
import java.util.List;

public class Model {

    List<UserData> users;

    public Model() {
    }

    public void add(UserData newUser) {
        if (users == null) {
            users = new ArrayList<>();
        }

        users.add(newUser);
    }

    public boolean isValidNickname(String nickname) {
        if (users != null) {
            for (UserData data : users) {
                if (data.getNickName().equals(nickname)) return true;
            }
        }
        return false;
    }
}
