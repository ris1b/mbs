package com.movieapp.mbs.strategies;

import com.movieapp.mbs.models.Booking;
import com.movieapp.mbs.models.ShowSeat;

import java.util.List;

public interface PricingStrategy {

    /**
     * On the basis of the Booking, price would be calculated.*/
    Double calculatePrice(Booking booking, List<ShowSeat> showSeats);


}
