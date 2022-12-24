package api.conrtollers;

import api.ApiClient;
import api.models.ResponseBoards;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import utils.testData.Users;

import java.util.List;

public class BoardController {

    public List<ResponseBoards> getAllBoardsList(Users user, int expectedStatusCode) {
        String endPointAllBoards = "/1/members/me/boards";

        ApiClient api = new ApiClient();
        Response r = api.addContentTypeJson()
                .addQueryParam("key", user.getKey())
                .addQueryParam("token", user.getToken())
                .build()
                .sendRequest(Method.GET, expectedStatusCode, endPointAllBoards);
        JsonPath jsonPath = r.jsonPath();
        return jsonPath.getList(".", ResponseBoards.class);
    }

    public ResponseBoards createBoard(Users user, String boardName, int expectedStatusCode) {
        String endPointCreateBoard = "/1/boards";

        Response response = new ApiClient().addContentTypeJson()
                .addQueryParam("key", user.getKey())
                .addQueryParam("token", user.getToken())
                .addQueryParam("name", boardName)
                .build()
                .sendRequest(Method.POST, expectedStatusCode, endPointCreateBoard);
        return response.jsonPath().getObject(".", ResponseBoards.class);
    }

    public void deleteTable(Users user, String idBoard, int expectedStatusCode) {
        String endPointDeleteBoard = "/1/boards/{pathParam}";

        new ApiClient().addContentTypeJson()
                .addQueryParam("key", user.getKey())
                .addQueryParam("token", user.getToken())
                .addPathParam(idBoard)
                .build()
                .sendRequest(Method.DELETE, expectedStatusCode, endPointDeleteBoard);
    }

}
