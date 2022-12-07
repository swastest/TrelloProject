package api.tests;

import api.models.CreateNewBoardRequest;
import configProperties.UserProperties;
import io.restassured.http.ContentType;
import api.models.ProfileResponse;
import api.models.ResponseCards;
import org.aeonbits.owner.ConfigFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;

public class TestApi {
    static UserProperties userConfig = ConfigFactory.create(UserProperties.class, System.getProperties());
    @Test
    void boards() {
        ResponseCards[] r = given()
                .queryParam("key", userConfig.apiKey())
                .queryParam("token", userConfig.secretToken())
                .get(userConfig.url() + EndPoints.ALL_BOARDS.getPath())
                .then().log().all()
                .statusCode(200)
                .extract().as(ResponseCards[].class);
        List<String> f = Arrays.stream(r).filter(e -> e.getDateClosed() == null)
                .map(e -> e.getName()).collect(Collectors.toList());
        Assertions.assertThat(f).contains("LiC - Ошибки");
    }

    @Test
    void profile() {
        ProfileResponse r = given()
                .queryParam("key", userConfig.apiKey())
                .queryParam("token", userConfig.secretToken())
                .get(userConfig.url() + EndPoints.PROFILE.getPath())
                .then().log().all()
                .statusCode(200)
                .extract().as(ProfileResponse.class);
        Assertions.assertThat(r.getAvatarUrl()).contains("trello");
        Assertions.assertThat(r.getInitials()).isEqualTo("T");

    }

    @Test
    void createBoard() {

        CreateNewBoardRequest create = CreateNewBoardRequest.builder()
                .name("cardName")
                .defaultLists(true)
                .idOrganization("637090343986fb040f143e61")
                .prefsBackgroundUrl("https://images.unsplash.com/photo-1668138643124-6b714461f7e2?ixid" +
                        "=Mnw3MDY2fDB8MXxjb2xsZWN0aW9ufDF8MzE3MDk5fHx8fHwyfHwxNjY4MzI1NTMy&ixlib=rb-4.0.3&w=2560&h=2048&q=90")
                .prefsPermissionLevel("org")
                .prefsSelfJoin(true)
                .token(userConfig.tokenCard())
                .build();
        CreateNewBoardRequest resp = given()
                .cookie("preAuthProps", Ex1.getPreAuthPropsCookies())
                .cookie("token", userConfig.tokenCard())
                .contentType(ContentType.JSON)
                .body(create)
                .when()
                .post(userConfig.url() + EndPoints.CRETE_BOARD.getPath())
                .then().log().all()
                .statusCode(200)
                .extract().as(CreateNewBoardRequest.class);
        Assertions.assertThat(resp.getName()).isEqualTo("cardName");
        Ex1.deleteCard(resp.getId());
    }

}
