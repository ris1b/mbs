package com.movieapp.mbs.strategies;

import com.movieapp.mbs.enums.SeatType;
import com.movieapp.mbs.models.Booking;
import com.movieapp.mbs.models.ShowSeat;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SeatBasedPricingStrategy implements PricingStrategy {

    @Override
    public Double calculatePrice(Booking booking, List<ShowSeat> showSeats) {
        // Iterate over show seats
        // For each show seat -> get the price
        // eg. PLATINUM seat -> Rs 1000
        // add all prices
        return showSeats.stream().mapToDouble(
                seat -> getPrice(seat.getSeat().getSeatType())
        ).sum();
    }

    // TODO : Move to the database
    // (theatre_id, se at_type) -> price mapping
    private static double getPrice(SeatType seatType) {
        switch (seatType) {
            case VIP -> {
                return 2000.0;
            }
            case PLATINUM -> {
                return 1000.0;
            }
            case GOLD -> {
                return 500.0;
            }
            case SILVER -> {
                return 250.0;
            }
        }
        throw  new IllegalArgumentException("Invalid type: " + seatType);
    }
}