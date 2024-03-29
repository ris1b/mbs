package com.movieapp.mbs.repositories;

import com.movieapp.mbs.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    Optional<Movie> findMovieByName(String name);

    List<Movie> findAllByName(String name);
}
