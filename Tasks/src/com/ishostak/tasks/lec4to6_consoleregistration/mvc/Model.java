package com.ishostak.tasks.lec4to6_consoleregistration.mvc;

import com.ishostak.tasks.lec4to6_consoleregistration.helper.UserData;

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

    public boolean isInvalidNickname(String nickname) {
        if (users != null) {
            for (UserData data : users) {
                if (data.getNickName().equals(nickname)) return true;
            }
        }
        return false;
    }
}
