package org.jackson.Deserialization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.jackson.Serialization.Booking;
import org.testng.annotations.Test;

public class deserialization {

@Test
    public void deserializationTest() throws JsonProcessingException {
        String jacksonpayload = "{\n" +
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

    ObjectMapper objectMapper = new ObjectMapper();
     Booking booking = objectMapper.readValue(jacksonpayload, Booking.class);
    System.out.println(booking);
        System.out.println(booking.getFirstname());
        System.out.println(booking.getLastname());



    }

}
