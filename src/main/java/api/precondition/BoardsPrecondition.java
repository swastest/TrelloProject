package api.precondition;

import api.models.ResponseBoards;
import utils.UserController;
import utils.testData.EndPoints;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

public class BoardsPrecondition {
    UserController u = new UserController();

    public ResponseBoards[] boards(String login) {
        return given()
                .queryParam("key", u.getUserKey(login))
                .queryParam("token", u.getUserToken(login))
                .get("https://api.trello.com" + EndPoints.ALL_BOARDS.getPath())
                .then().log().all()
                .statusCode(200)
                .extract().as(ResponseBoards[].class);
    }

    public void createBoard(String login, String boardName) {
        given()
                .queryParam("key", u.getUserKey(login))
                .queryParam("token", u.getUserToken(login))
                .queryParam("name", boardName)
                .contentType(JSON)
                .when().log().all()
                .post("https://api.trello.com" + EndPoints.CRETE_BOARD.getPath())
                .then().log().all()
                .statusCode(200);
    }

    public void deleteBoard(String login, String idBoard) {
        given()
                .queryParam("key", u.getUserKey(login))
                .queryParam("token", u.getUserToken(login))
                .pathParam("idBoard", idBoard)
                .when().log().all()
                .delete("https://api.trello.com"+EndPoints.DELETE_BOARD.getPath()+"{idBoard}")
                .then().log().all()
                .statusCode(200);
    }
}
