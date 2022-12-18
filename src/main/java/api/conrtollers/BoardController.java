package api.conrtollers;

import api.ApiClient;
import api.models.ResponseBoards;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import utils.testData.EndPoints;
import utils.testData.Users;

import java.util.List;

public class BoardController {

    public List<ResponseBoards> getAllBoardsList(Users user, int expectedStatusCode) {
        ApiClient api = new ApiClient();
        Response r = api.addContentTypeJson()
                .addQueryParam("key", user.getKey())
                .addQueryParam("token", user.getToken())
                .build()
                .sendRequest(Method.GET, expectedStatusCode, EndPoints.ALL_BOARDS);
        JsonPath jsonPath = r.jsonPath();
        return jsonPath.getList(".", ResponseBoards.class);
    }

    public ResponseBoards createBoard(Users user, String boardName, int expectedStatusCode) {
        Response response = new ApiClient().addContentTypeJson()
                .addQueryParam("key", user.getKey())
                .addQueryParam("token", user.getToken())
                .addQueryParam("name", boardName)
                .build()
                .sendRequest(Method.POST, expectedStatusCode, EndPoints.CRETE_BOARD);
        return response.jsonPath().getObject(".", ResponseBoards.class);
    }

    public void deleteTable(Users user, String idBoard, int expectedStatusCode) {
        new ApiClient().addContentTypeJson()
                .addQueryParam("key", user.getKey())
                .addQueryParam("token", user.getToken())
                .addPathParam(idBoard)
                .build()
                .sendRequest(Method.DELETE, expectedStatusCode, EndPoints.DELETE_BOARD);
    }

}
