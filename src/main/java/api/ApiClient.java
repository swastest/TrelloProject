package api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.testData.EndPoints;

import java.nio.charset.StandardCharsets;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.config.EncoderConfig.encoderConfig;
import static io.restassured.config.RestAssuredConfig.newConfig;

public class ApiClient {
    private RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder()
            .setConfig(newConfig().encoderConfig(encoderConfig()
                    .defaultContentCharset(StandardCharsets.UTF_8)))
            .setBaseUri("https://api.trello.com")
            .log(LogDetail.ALL);

    private RequestSpecification requestSpec;

    public Response sendRequest(Method method, int expectedStatusCode, EndPoints endPoints, Object... params) {
        return given()
                .spec(requestSpec)
                .request(method, endPoints.getPath(), params)
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
}
