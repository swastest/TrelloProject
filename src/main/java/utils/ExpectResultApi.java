package utils;

import api.models.ResponseBoards;
import io.restassured.response.Response;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static io.restassured.RestAssured.given;

public class ExpectResultApi {
    Response getAllBoardsInSpace(String spaseId) {
        return given()
                .cookie("token", "62139573dbacb081f8597567%2FATTSU5ZyQ2XwWnP8cpR3JkmHFs1AZoociWBhitLpzETKiofd3FfrcQcOntU4skgOeQ8S9B5812B0")
                .pathParam("spaseId", spaseId)
                .queryParam("boards", "open")
                .queryParam("boards_sortBy", "dateLastActivity")
                .get("https://trello.com/1/organization/{spaseId}")
                .then()
                .statusCode(200).extract().response();
    }

    ResponseBoards[] getAllBoards(String key, String token) {
        return given()
                .queryParam("key", key)
                .queryParam("token", token)
                .get("https://api.trello.com/1/members/me/boards")
                .then()
                .statusCode(200).extract().as(ResponseBoards[].class);
    }

    public List<String> actualAiiBoards() {
        return Stream.of(getAllBoards("55eda7b2197cf309073dd4573b7356f0",
                        "26f2f8963ec5c6acb8e9e88b524332c9a2922dd58d24a329e432b4494f972a06"))
                .filter(e -> e.getClosed() != true).map(ResponseBoards::getName).collect(Collectors.toList());
    }

}

