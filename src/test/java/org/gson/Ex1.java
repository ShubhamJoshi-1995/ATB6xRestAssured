package org.gson;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Ex1 {

    @Description("TC1")
    @Test
    public void PingRequest() {

        RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/ping")
                .when().get().then().statusCode(201);
    }


    @Description("TC2")
    @Test
    public void PingRequest2() {

        RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/ping")
                .when().get().then().statusCode(201);
    }
}