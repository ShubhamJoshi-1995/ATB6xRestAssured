package org.jackson.Serialization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class createBookingUsingC {

    @Test
    public void Cb() throws JsonProcessingException {

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

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonpayloadstring =objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(booking);
        System.out.println(jsonpayloadstring);


        rs.baseUri(BASEURL);
        rs.basePath(BASEPATH);
        rs.contentType(ContentType.JSON);
        rs.body(booking);


        response = rs.when().log().all().post();


        vr = response.then().log().all().statusCode(200);



    }


}
