package api.tests;

import configProperties.UserProperties;
import io.restassured.response.Response;
import org.aeonbits.owner.ConfigFactory;

import static io.restassured.RestAssured.given;

public class Ex1 {
    static UserProperties userConfig = ConfigFactory.create(UserProperties.class, System.getProperties());
    public static String DSC_COOKIES;
    public static String PRE_AUTH_PROPS_COOKIES;

    public static String getDscCookies() {
        if (DSC_COOKIES == null)
            DSC_COOKIES = setResponseAuth().getCookie("dsc");
        PRE_AUTH_PROPS_COOKIES = setResponseAuth().getCookie("preAuthProps");
        return DSC_COOKIES;
    }

    public static String getPreAuthPropsCookies() {
        if (PRE_AUTH_PROPS_COOKIES == null)
            PRE_AUTH_PROPS_COOKIES = setResponseAuth().getCookie("preAuthProps");
        DSC_COOKIES = setResponseAuth().getCookie("dsc");
        return PRE_AUTH_PROPS_COOKIES;
    }

    static Response setResponseAuth() {
        Response r = given()
                .queryParam("key", userConfig.apiKey())
                .queryParam("token", userConfig.secretToken())
                .get("https://api.trello.com/1/members/me")
                .then().log().all()
                .statusCode(200)
                .extract().response();
        if (PRE_AUTH_PROPS_COOKIES == null)
            PRE_AUTH_PROPS_COOKIES = r.getCookie("preAuthProps");
        if (DSC_COOKIES == null)
            DSC_COOKIES = r.getCookie("dsc");
        return r;
    }

    static void deleteCard(String cardId) {
        given()
                .queryParam("key", userConfig.apiKey())
                .queryParam("token", userConfig.secretToken())
                .delete(userConfig.url() + "/1/boards/" + cardId)
                .then().log().all().statusCode(200);
    }

}
