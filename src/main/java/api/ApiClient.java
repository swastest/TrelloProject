package api;

import configProperties.UserProperties;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.aeonbits.owner.ConfigFactory;

import java.nio.charset.StandardCharsets;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.config.EncoderConfig.encoderConfig;
import static io.restassured.config.RestAssuredConfig.newConfig;
import static utils.CustomApiListener.withCustomTemplates;

public class ApiClient {

    UserProperties userProperties = ConfigFactory.create(UserProperties.class,System.getProperties());
    private final RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder()
            .setConfig(newConfig().encoderConfig(encoderConfig()
                    .defaultContentCharset(StandardCharsets.UTF_8)))
            .setBaseUri(userProperties.uri())
            .log(LogDetail.ALL);

    private RequestSpecification requestSpec;

    public Response sendRequest(Method method, int expectedStatusCode, String endPoint, Object... pathParams) {
        return given()
                .spec(requestSpec)
                .filter(withCustomTemplates())
                .request(method, endPoint, pathParams)
                .then().log().all().statusCode(expectedStatusCode).extract().response();
    }

    public ApiClient build() {
        requestSpec = requestSpecBuilder.build();
        return this;
    }

    public ApiClient addQueryParam(String key, String value) {
        requestSpecBuilder.addQueryParam(key, value);
        return this;
    }

    public ApiClient addPathParam(String pathParam) {
        requestSpecBuilder.addPathParam("pathParam", pathParam);
        return this;
    }

    public ApiClient addBody(String body) {
        requestSpecBuilder.setBody(body);
        return this;
    }

    public ApiClient addBody(Map<String, String> body) {
        requestSpecBuilder.setBody(body);
        return this;
    }

    public ApiClient addBody(Object body) {
        requestSpecBuilder.setBody(body);
        return this;
    }

    public ApiClient addContentTypeJson() {
        requestSpecBuilder.setContentType(ContentType.JSON);
        return this;
    }

    public ApiClient addContentTypeForFormParam() {
        requestSpecBuilder.setContentType(ContentType.URLENC);
        return this;
    }

    public ApiClient addFormParam(String key, String value) {
        requestSpecBuilder.addFormParam(key, value);
        return this;
    }

    public ApiClient addCookies(Map<String,String> cookies){
        requestSpecBuilder.addCookies(cookies);
        return this;
    }

    public ApiClient addCookies(String cookie){
        requestSpecBuilder.addCookie(cookie);
        return this;
    }
}
