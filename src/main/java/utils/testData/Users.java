package utils.testData;

public enum Users {
    USER1("nid.swastest@gmail.com", "Pass_password");

    private String login;
    private String password;

    Users(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
