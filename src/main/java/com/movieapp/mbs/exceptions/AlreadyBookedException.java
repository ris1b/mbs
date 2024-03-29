package com.movieapp.mbs.exceptions;

import java.util.List;

public class AlreadyBookedException extends RuntimeException {

    public AlreadyBookedException(Long showSeatId) {
        super("Seat already booked: " + showSeatId);
    }
}
