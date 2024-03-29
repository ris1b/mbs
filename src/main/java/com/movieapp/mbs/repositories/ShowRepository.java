package com.movieapp.mbs.repositories;

import com.movieapp.mbs.models.Show;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowRepository extends JpaRepository<Show, Long> {
}
