package utils.testData;

public enum Users {
    TEST_USER_1("nid.swastest@gmail.com", "Pass_password"
            , "7038418dc2777ef93b741272fa4d4c3ced7a8eead851c8a52a0c5f067760e073"
            , "70997886221a97663a85a05cd4dba37e",
            "cd6680044f703901f9d83903ef081652532cbeb8cba954ca896ffee18179c209");

    private String login;
    private String password;
    private String token;
    private String key;
    private String secret;

    Users(String login, String password, String token, String key, String secret) {
        this.login = login;
        this.password = password;
        this.token = token;
        this.key = key;
        this.secret = secret;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getToken() {
        return token;
    }

    public String getKey() {
        return key;
    }

    public String getSecret() {
        return secret;
    }
}
