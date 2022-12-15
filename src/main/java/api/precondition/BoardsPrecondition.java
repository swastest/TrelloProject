package api.precondition;

import api.models.ResponseBoards;
import utils.testData.EndPoints;
import utils.testData.Users;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

public class BoardsPrecondition {

    public ResponseBoards[] boards(Users users) {
        return given()
                .queryParam("key", users.getKey())
                .queryParam("token", users.getToken())
                .get("https://api.trello.com" + EndPoints.ALL_BOARDS.getPath())
                .then().log().all()
                .statusCode(200)
                .extract().as(ResponseBoards[].class);
    }

    public void createBoard(Users users, String boardName) {
        given()
                .queryParam("key", users.getKey())
                .queryParam("token", users.getToken())
                .queryParam("name", boardName)
                .contentType(JSON)
                .when().log().all()
                .post("https://api.trello.com" + EndPoints.CRETE_BOARD.getPath())
                .then().log().all()
                .statusCode(200);
    }

    public void deleteBoard(Users users, String idBoard) {
        given()
                .queryParam("key", users.getKey())
                .queryParam("token", users.getToken())
                .pathParam("idBoard", idBoard)
                .when().log().all()
                .delete("https://api.trello.com"+EndPoints.DELETE_BOARD.getPath()+"{idBoard}")
                .then().log().all()
                .statusCode(200);
    }
}
