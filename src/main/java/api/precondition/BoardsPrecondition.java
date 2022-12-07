package api.precondition;

import api.models.ResponseBoards;
import utils.UserController;
import utils.testData.EndPoints;

import java.util.List;

import static io.restassured.RestAssured.given;

public class BoardsPrecondition {
   public List<ResponseBoards> boards(String login) {
        UserController u = new UserController();
        return (List<ResponseBoards>) given()
                .queryParam("key", u.getUserKey(login))
                .queryParam("token", u.getUserToken(login))
                .get("https://api.trello.com" + EndPoints.ALL_BOARDS.getPath())
                .then().log().all()
                .statusCode(200)
                .extract().as(ResponseBoards.class);
    }
}
