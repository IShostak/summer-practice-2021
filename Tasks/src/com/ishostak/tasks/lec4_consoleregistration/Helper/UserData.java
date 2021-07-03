package com.ishostak.tasks.lec4_consoleregistration.Helper;

public class UserData {

    private String firstName;
    private String lastName;
    private String email;
    private String nickName;
    private String surname;
    private String phoneNumber;

    private UserData() {

    }

    public class Builder {
        private UserData newUserData;

        public Builder() {
            newUserData = new UserData();
        }

        public Builder withFirstName(String name) {
            newUserData.firstName = name;
            return this;
        }

        public Builder withLastName(String lastName) {
            newUserData.lastName = lastName;
            return this;
        }

        public Builder withEmail(String email) {
            newUserData.email = email;
            return this;
        }

        public Builder withNickName(String nickName) {
            newUserData.nickName = nickName;
            return this;
        }

        public Builder withSurName(String surname) {
            newUserData.surname = surname;
            return this;
        }

        public Builder withPhoneNumber(String withPhoneNumber) {
            newUserData.phoneNumber = withPhoneNumber;
            return this;
        }

        public UserData build() {
            return newUserData;
        }
    }

    public String getSurname() {
        return surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getNickName() {
        return nickName;
    }
}
