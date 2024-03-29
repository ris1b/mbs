package com.movieapp.mbs.controllers;

import com.movieapp.mbs.dtos.CreateBookingRequest;
import com.movieapp.mbs.models.Booking;
import com.movieapp.mbs.services.BookingService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/booking")
@AllArgsConstructor
public class BookingController {

    private BookingService bookingService;
    @PostMapping
    public Booking createBooking(@RequestBody CreateBookingRequest bookingRequest){
        return bookingService.createBooking(bookingRequest);
    }

}
