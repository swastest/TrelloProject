package utils;

import utils.testData.Users;

public class UserController {
    public String getUserPass(String login) {
        if(login.equals(Users.USER1.getLogin())){
            return Users.USER1.getPassword();
        }
        return "Нет такого юзера";
    }

}
