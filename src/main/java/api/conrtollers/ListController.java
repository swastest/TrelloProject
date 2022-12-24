package api.conrtollers;

import api.ApiClient;
import api.models.ResponseList;
import io.restassured.http.Method;
import utils.testData.Users;

import java.util.List;

public class ListController {

    public ResponseList createNewListOnBoard(Users user, String listName, String idBoard, int expectedStatusCode) {
        String endPointCreateList = "/1/lists";

        return new ApiClient()
                .addQueryParam("key", user.getKey())
                .addQueryParam("token", user.getToken())
                .addQueryParam("name", listName)
                .addQueryParam("idBoard", idBoard)
                .build().sendRequest(Method.POST, expectedStatusCode, endPointCreateList)
                .jsonPath().getObject(".", ResponseList.class);
    }

    public List<ResponseList> getAllListsOnBoard(Users user, String idBoard, int expectedStatusCode) {
        String endPointGetListsOnBoards = "/1/boards/{pathParam}/lists";

        return new ApiClient()
                .addQueryParam("key", user.getKey())
                .addQueryParam("token", user.getToken())
                .addPathParam(idBoard)
                .build().sendRequest(Method.GET,expectedStatusCode,endPointGetListsOnBoards)
                .jsonPath().getList(".", ResponseList.class);
    }
}
