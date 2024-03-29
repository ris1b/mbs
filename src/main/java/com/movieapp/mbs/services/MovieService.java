package com.movieapp.mbs.services;

import com.movieapp.mbs.exceptions.MovieAlreadyExistsException;
import com.movieapp.mbs.exceptions.MovieNotFoundException;
import com.movieapp.mbs.models.Movie;
import com.movieapp.mbs.repositories.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class MovieService {

    private MovieRepository movieRepository;
    public Movie createMovie(Movie movie) {
        // Validate if a movie of the same name exists or not
        // Yes ? throw an error
        Optional<Movie> existingMovie = movieRepository.findMovieByName(movie.getName());
        if(existingMovie.isPresent()) {
            throw new MovieAlreadyExistsException(movie.getName());
        }

        // else Persist the movie
        return movieRepository.save(movie);

    }

    public Movie getMovie(Long movieId) {
        return movieRepository
                .findById(movieId)
                .orElseThrow(() -> new MovieNotFoundException(movieId));
    }

    public Movie getMovieInternal(Long movieId) {
        return movieRepository
                .findById(movieId)
                .orElse(null);
    }
}
