package com.movieapp.mbs.services;

import com.movieapp.mbs.models.Hall;
import com.movieapp.mbs.repositories.HallRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class HallService {

    private HallRepository hallRepository;

    // this is an internal method, sending null instead of throwing exceptions !
    public Hall getHallInternal(Long hallId) {
        return hallRepository
                .findById(hallId)
                .orElse(null);
    }
}
