package api.conrtollers;

import api.ApiClient;
import api.models.ResponseBoards;
import io.restassured.http.Method;
import utils.testData.Users;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class BoardController {

    public List<ResponseBoards> getAllBoardsList(Users user, int expectedStatusCode) {
        String endPointAllBoards = "/1/members/me/boards?key={key}&token={token}";

        return new ApiClient().addContentTypeJson()
                .build()
                .sendRequest(Method.GET, expectedStatusCode, endPointAllBoards,
                        user.getKey(), user.getToken()).jsonPath().getList(".", ResponseBoards.class);
    }

    //если бы нужно было передавать куки
    public List<ResponseBoards> getAllBoardsList(Users user, int expectedStatusCode, Map<String,String> cookies) {
        String endPointAllBoards = "/1/members/me/boards?key={key}&token={token}";

        return new ApiClient().addContentTypeJson()
                .addCookies(cookies)
                .build()
                .sendRequest(Method.GET, expectedStatusCode, endPointAllBoards,
                        user.getKey(), user.getToken()).jsonPath().getList(".", ResponseBoards.class);
    }

    public ResponseBoards createBoard(Users user, String boardName, int expectedStatusCode) {
        String endPointCreateBoard = "/1/boards?key={key}&token={token}";

        return new ApiClient().addContentTypeJson()
                .addQueryParam("name", boardName)
                .addQueryParam("idOrganization","638cdc0a8f3b9301e26a53e5")
                .build()
                .sendRequest(Method.POST, expectedStatusCode, endPointCreateBoard,
                        user.getKey(), user.getToken()).jsonPath().getObject(".", ResponseBoards.class);
    }

    public void deleteTable(Users user, String idBoard, int expectedStatusCode) {
        String endPointDeleteBoard = "/1/boards/{pathParam}?key={key}&token={token}";

        new ApiClient().addContentTypeJson()
                .build()
                .sendRequest(Method.DELETE, expectedStatusCode, endPointDeleteBoard,
                        idBoard, user.getKey(), user.getToken());
    }

}
