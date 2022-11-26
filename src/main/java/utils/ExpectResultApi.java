package utils;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ExpectResultApi {
    Response getAllBoardsInSpace(String spaseId){
        return given()
                .pathParam("spaseId", spaseId)
                .queryParam("boards", "open")
                .queryParam("boards","open")
                .get("https://trello.com/1/organization/{spaseId}")
                .then()
                .statusCode(200).extract().response();
    }

}
