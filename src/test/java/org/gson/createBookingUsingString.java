package org.gson;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import com.github.javafaker.Faker;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;

public class createBookingUsingString {

/* Payload Using String */


    @Test
    public  void Cb(){

        RequestSpecification rs = RestAssured.given();
        Response response;
        ValidatableResponse vr;

        String BASEURL = "https://restful-booker.herokuapp.com";
        String BASEPATH = "/booking";
        String Payload = "{\n" +
                "    \"firstname\" : \"Jim\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        rs.baseUri(BASEURL);
        rs.basePath(BASEPATH);
        rs.contentType(ContentType.JSON);
        rs.body(Payload);

        response = rs.when().log().all().post();


        vr= response.then().log().all().statusCode(200);
       vr.body("firstname" , Matchers.equalToIgnoringCase("Jim"));


    }





}
