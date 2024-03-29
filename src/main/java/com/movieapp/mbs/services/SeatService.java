package com.movieapp.mbs.services;

import com.movieapp.mbs.models.Seat;
import com.movieapp.mbs.repositories.SeatRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SeatService {

    private SeatRepository seatRepository;

    public List<Seat> saveAll(List<Seat> seats) {
        return seatRepository.saveAll(seats);
    }

    public List<Seat> getAll(Long hallId){
        return seatRepository.findAllByHall_Id(hallId);
    }
}
