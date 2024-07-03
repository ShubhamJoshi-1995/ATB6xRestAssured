package org.example;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class AuthRequest {





    RequestSpecification rs = RestAssured.given();
    Response response;
    ValidatableResponse vr;

    @Test
    public void authRequest(){

        String BASEURL = "https://restful-booker.herokuapp.com";
        String BASEPATH = "/auth";
        String payload =  "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        rs.baseUri(BASEURL);
        rs.basePath(BASEPATH);
        rs.contentType(ContentType.JSON);
        rs.body(payload);

       response = rs.when().log().all().post();


       vr= response.then().log().all().statusCode(200);
       vr.body("token",Matchers.equalTo("token"));





    }
}
