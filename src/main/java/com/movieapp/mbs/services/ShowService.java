package com.movieapp.mbs.services;

import com.movieapp.mbs.dtos.CreateShowRequest;
import com.movieapp.mbs.enums.SeatStatus;
import com.movieapp.mbs.models.*;
import com.movieapp.mbs.repositories.ShowRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class ShowService {

    private ShowRepository showRepository;

    private HallService hallService;
    private MovieService movieService;
    private SeatService seatService;
    private ShowSeatService showSeatService;

    public Show createShow(CreateShowRequest request) {

        // Create a method
        // Create a show
        // -- Validate the hall
        Hall hall = hallService.getHallInternal(request.getHallId());
        if(hall == null) {
            throw new NoSuchElementException("Hall does not exist : " + request.getHallId());
        }

        // -- Validate movie
        Movie movie = movieService.getMovieInternal(request.getMovieId());
        if(movie == null) {
            throw new NoSuchElementException("Movie does not exist : " + request.getMovieId());
        }

        // -- Persist the show
        Show show = Show.builder()
                .hall(hall)
                .startTime(request.getStartTime())
                .movie(movie)
                .build();

        // and when we persist the show, we also want to persist the show seats as well
        // -- Persist the show seats (Seats)
        List<Seat> seats = seatService.getAll(hall.getId());

        // now we would combine the show and the seats
        // so creating a list of show seats (based on the seats of the hall)
        List<ShowSeat> showSeats = seats.stream().map(
                seat -> ShowSeat.builder()
                        .seat(seat)
                        .show(show)
                        .status(SeatStatus.AVAILABLE)
                        .build()
        ).toList();

        showSeatService.create(showSeats);

        return show;
    }

    public Show getShow(Long id){
        return showRepository.findById(id).orElseThrow(() -> new NoSuchElementException(("Invalid show ID: " + id)));
    }
}
