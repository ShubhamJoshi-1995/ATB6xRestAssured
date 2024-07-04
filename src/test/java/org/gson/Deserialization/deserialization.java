package org.gson.Deserialization;

import com.google.gson.Gson;
import org.gson.Serialization.Booking;
import org.testng.annotations.Test;

public class deserialization {

@Test
    public void deserializationTest() {
        String gsonPayload = "{\n" +
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

        Gson gson = new Gson();
        Booking booking = gson.fromJson(gsonPayload, Booking.class);
    System.out.println(booking);
        System.out.println(booking.getFirstname());
        System.out.println(booking.getLastname());



    }

}
