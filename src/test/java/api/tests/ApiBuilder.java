package api.tests;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.with;

public class ApiBuilder {
    public static RequestSpecification request = with().baseUri("")
            .basePath("")
            .log().all()
            .contentType(ContentType.JSON);

    public ApiBuilder addQuery(String key, String param){
        RequestSpecification request1 = new RequestSpecBuilder().addQueryParam(key,param)
                .build();
        return this;
    }

}
