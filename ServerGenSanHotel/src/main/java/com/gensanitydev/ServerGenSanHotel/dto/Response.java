package com.gensanitydev.ServerGenSanHotel.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.time.LocalDate;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {

    private int statusCode;


    private String message;

    private String token;

    private String role;

    private String bookingConfirmationCode;

    private String expirationTime;


    private int totalNumOfGuests;
    

    private UserDTO user;

    private RoomDTO room;

}
