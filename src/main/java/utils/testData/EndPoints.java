package utils.testData;

public enum EndPoints {
    PROFILE("/1/members/me"),
    CRETE_BOARD("/1/boards"),
    ALL_BOARDS("/1/members/me/boards"),
    DELETE_CARD("");

    private String path;

    EndPoints(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
