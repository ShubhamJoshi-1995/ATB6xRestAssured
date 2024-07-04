package org.gson.Serialization;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class createBookingUsingC {

    @Test
    public void Cb() {

        RequestSpecification rs = RestAssured.given();
        Response response;
        ValidatableResponse vr;

        String BASEURL = "https://restful-booker.herokuapp.com";
        String BASEPATH = "/booking";
        Booking booking = new Booking();
        booking.setFirstname("Shubham");
        booking.setLastname("Joshi");
        booking.setTotalprice(111);
        booking.setDepositpaid(false);

        BookingDates bookingDates = new BookingDates();

        bookingDates.setCheckin("2018-01-01");
        bookingDates.setCheckout("2019-01-01");
        booking.setBookingdates(bookingDates);

        booking.setAdditionalneeds("Lunch");

        System.out.println(booking.toString());

        Gson gson = new Gson();
        String gsonstringPayload = gson.toJson(booking);
        System.out.println(gsonstringPayload);



        rs.baseUri(BASEURL);
        rs.basePath(BASEPATH);
        rs.contentType(ContentType.JSON);
        rs.body(booking);


        response = rs.when().log().all().post();


        vr = response.then().log().all().statusCode(200);



    }


}
