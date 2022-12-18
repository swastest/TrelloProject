package utils.testData;

public enum EndPoints {
    ALL_BOARDS("/1/members/me/boards"),
    CRETE_BOARD("/1/boards"),
    DELETE_BOARD("/1/boards/{pathParam}"),
    PROFILE("/1/members/me"),
    GET_LISTS_ON_BOARD("/1/boards/{pathParam}/lists"),
    CREATE_LIST("/1/lists");

    private String path;

    EndPoints(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
