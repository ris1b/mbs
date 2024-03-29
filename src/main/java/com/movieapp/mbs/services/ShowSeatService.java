package com.movieapp.mbs.services;

import com.movieapp.mbs.models.ShowSeat;
import com.movieapp.mbs.repositories.ShowSeatRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ShowSeatService {

    private ShowSeatRepository showSeatRepository;

    public List<ShowSeat> saveAll(List<ShowSeat> lockedSeats){
        return showSeatRepository.saveAll(lockedSeats);
    }

    public void create(List<ShowSeat> showSeats) {
        this.saveAll(showSeats);
    }

    public List<ShowSeat> getShowSeats(List<Long> showSeatIds) {
        return showSeatRepository.findAllById(showSeatIds);
    }


}
