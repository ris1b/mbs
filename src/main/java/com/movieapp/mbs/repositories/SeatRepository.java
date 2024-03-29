package com.movieapp.mbs.repositories;

import com.movieapp.mbs.models.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {

    /* Query based on Hall id*/
    List<Seat> findAllByHall_Id(Long id);
}
