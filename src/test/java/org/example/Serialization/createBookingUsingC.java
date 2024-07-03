package org.example.Serialization;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class createBookingUsingC {

    @Test
    public void Cb() {

        RequestSpecification rs = RestAssured.given();
        Response response;
        ValidatableResponse vr;

        String BASEURL = "https://restful-booker.herokuapp.com";
        String BASEPATH = "/booking";
        Booking testbk = new Booking();
        testbk.setFirstname("Shubham");
        testbk.setLastname("Joshi");
        testbk.setTotalprice(111);
        testbk.setDepositpaid(false);

        BookingDates testbd = new BookingDates();

        testbd.setCheckin("2018-01-01");
        testbd.setCheckout("2019-01-01");
        testbk.setBookingdates(testbd);

        testbk.setAdditionalneeds("Lunch");

        System.out.println(testbk.toString());

        Gson gson = new Gson();
        String gsonstringPayload = gson.toJson(testbk);
        System.out.println(gsonstringPayload);



//        rs.baseUri(BASEURL);
//        rs.basePath(BASEPATH);
//        rs.contentType(ContentType.JSON);
//        rs.body(testbk);
//
//
//        response = rs.when().log().all().post();
//
//
//        vr = response.then().log().all().statusCode(200);
//        vr.body("firstname", Matchers.equalToIgnoringCase("Jim"));


    }


}
