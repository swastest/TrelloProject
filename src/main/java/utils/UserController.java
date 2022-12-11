package utils;

import utils.testData.Users;

public class UserController {
    public String getUserPass(String login) {
        if (login.equals(Users.USER1.getLogin())) {
            return Users.USER1.getPassword();
        } else {
            System.out.println("Не знаю такого юзера");
        }
        return null;
    }

    public String getUserToken(String login) {
        if (login.equals(Users.USER1.getLogin())) {
            return Users.USER1.getToken();
        } else {
            System.out.println("Не знаю такого юзера");
        }
        return null;
    }

    public String getUserKey(String login) {
        if (login.equals(Users.USER1.getLogin())) {
            return Users.USER1.getKey();
        } else {
            System.out.println("Не знаю такого юзера");
        }
        return null;
    }
}
