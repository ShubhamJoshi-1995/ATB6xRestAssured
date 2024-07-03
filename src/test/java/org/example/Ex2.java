package org.example;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Ex2 {

    String BASEURL = "https://restful-booker.herokuapp.com";
    String BASEPATH = "/auth";
    String payload = "{\n" +
            "    \"username\" : \"admin\",\n" +
            "    \"password\" : \"password123\"\n" +
            "}";


    @Test
    public  void  authRequest(){

       RestAssured.given()
               .baseUri(BASEURL)
                .basePath(BASEPATH).contentType(ContentType.JSON).log().all().body(payload)
               .when().log().all().post()
               .then().log().all().statusCode(200);

    }
}
