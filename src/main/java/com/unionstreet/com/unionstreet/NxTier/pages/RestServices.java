package com.unionstreet.com.unionstreet.NxTier.pages;

import org.json.simple.JSONObject;

import com.jayway.restassured.response.Response;

import static com.jayway.restassured.RestAssured.given;

/**
 * Created by rajeshg on 01/09/2017.
 */
public class RestServices {

    String baseUrl = "http://test01-web01:61442";
    public Response response;

    public Response executeGetRequest(String systemInformation, String databaseName, String userName, String userNameParameter, String password, String passwordParameter,String url ) {
        response = given().
                header(systemInformation, databaseName).
                header(userName, userNameParameter).
                header(password,passwordParameter).
                contentType("application/json").
                when().
                get(baseUrl + url);
        return response;
    }
    public Response executeDeleteRequest(String systemInformation, String databaseName, String userName, String userNameParameter, String password, String passwordParameter,String url ) {
        response = given().
                header(systemInformation, databaseName).
                header(userName, userNameParameter).
                header(password,passwordParameter).
                contentType("application/json").
                when().
                delete(baseUrl + url);
        return response;
    }
    public Response executePostRequest(JSONObject payload,String systemInformation, String databaseName, String userName, String userNameParameter, String password, String passwordParameter,String url){
        response = given().body(payload).
                header(systemInformation, databaseName).
                header(userName, userNameParameter).
                header(password,passwordParameter).
                contentType("application/json").
                when().
                post(baseUrl + url);
        return response;
    }
    public Response executePATCHRequest(JSONObject payload,String systemInformation, String databaseName, String userName, String userNameParameter, String password, String passwordParameter,String url){
        response = given().body(payload).
                header(systemInformation, databaseName).
                header(userName, userNameParameter).
                header(password,passwordParameter).
                contentType("application/json").
                when().
                patch(baseUrl + url);
        return response;
    }

}
