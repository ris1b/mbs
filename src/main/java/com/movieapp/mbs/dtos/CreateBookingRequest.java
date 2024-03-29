package com.movieapp.mbs.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
public class CreateBookingRequest {

    private Long customerId;
    private Long showId;
    private List<Long> showSeatsIds = new ArrayList<>();    // the list which the user wants to book

}
