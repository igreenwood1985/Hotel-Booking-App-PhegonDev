package com.gensanitydev.ServerGenSanHotel.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.gensanitydev.ServerGenSanHotel.entity.Room;
import com.gensanitydev.ServerGenSanHotel.entity.User;
import lombok.Data;

import java.time.LocalDate;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookingDTO {

    private Long id;

    private LocalDate checkInDate;

    private LocalDate checkOutDate;

    private int numOfAdults;

    private int numOfChildren;

    private int numOfGuests;

    private String bookingConfirmationCode;

    private User user;

    private Room room;
}
