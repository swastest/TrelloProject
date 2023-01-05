package api.conrtollers;

import api.ApiClient;
import configProperties.UserProperties;
import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import org.aeonbits.owner.ConfigFactory;

import java.util.Map;

import static io.restassured.http.Method.GET;

public class AuthController {

    public Map<String, String> getAuthCookies(){
        UserProperties userProperties = ConfigFactory.create(UserProperties.class, System.getProperties());
        String endpointAuth = "/1/members/me";
      return   new ApiClient().addQueryParam("key", userProperties.apiKey())
                .addQueryParam("token", userProperties.apiKey())
                .sendRequest(GET,200,endpointAuth).getCookies();
    }
}
