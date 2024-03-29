package com.movieapp.mbs.services;

import com.movieapp.mbs.dtos.CreateBookingRequest;
import com.movieapp.mbs.enums.BookingStatus;
import com.movieapp.mbs.enums.SeatStatus;
import com.movieapp.mbs.exceptions.AlreadyBookedException;
import com.movieapp.mbs.models.Booking;
import com.movieapp.mbs.models.Customer;
import com.movieapp.mbs.models.Show;
import com.movieapp.mbs.models.ShowSeat;
import com.movieapp.mbs.repositories.BookingRepository;
import com.movieapp.mbs.strategies.PricingStrategy;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class BookingService {

    private BookingRepository bookingRepository;
    private CustomerService customerService;
    private ShowService showService;
    private ShowSeatService showSeatService;
    private PricingStrategy   pricingStrategy;

    public Booking createBooking(CreateBookingRequest bookingRequest) {
        //  validate customer id
        Customer customer = customerService.getCustomerIntenal(bookingRequest.getCustomerId());
        if(customer == null) {
            throw new NoSuchElementException("Customer not found with ID: " + bookingRequest.getCustomerId());
        }

        // validate the show id
        Show show = showService.getShow(bookingRequest.getShowId());
        if(show == null) {
            throw new NoSuchElementException("Show does not exist with ID: " + bookingRequest.getShowId());
        }

        List<ShowSeat> lockedSeats = lockSeats(bookingRequest);

        // save the Booking
        Booking booking = Booking.builder()
                .show(show)
                .customer(customer)
                .seats(lockedSeats)
                .bookedAt(new Date())
                .status(BookingStatus.PENDING)
                .build();

        Double amount = pricingStrategy.calculatePrice(booking, lockedSeats);
        Booking withAmount = booking.toBuilder()
                .amount(amount)
                .build();

        return bookingRepository.save(withAmount);
    }


    @Transactional(isolation = Isolation.SERIALIZABLE)
    public List<ShowSeat>  lockSeats(CreateBookingRequest bookingRequest) {
        // validate show seats
        // -- check if they are available or not ?
        List<ShowSeat> showSeats = showSeatService.getShowSeats(bookingRequest.getShowSeatsIds());  // got the list of show seats
        // next check if these seats are available or not ?
        for(ShowSeat showSeat : showSeats) {
            if(showSeat.getStatus() != SeatStatus.AVAILABLE) {
                throw new AlreadyBookedException(showSeat.getShow().getId());
            }
        }

        // Once we have validated everything -> we will change the seat status :: LOCKED
        List<ShowSeat> lockedSeats = showSeats.stream().map(
                seat -> seat.toBuilder()
                        .status(SeatStatus.LOCKED)
                        .build()
        ).toList();
        // if available, mark the seats reserved !

        // Save the seats
        showSeatService.saveAll(lockedSeats);

        return showSeatService.saveAll(lockedSeats);
    }

}
