package com.movieapp.mbs.controllers;

import com.movieapp.mbs.dtos.CreateMovieDTO;
import com.movieapp.mbs.models.Movie;
import com.movieapp.mbs.services.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movie")
@AllArgsConstructor
public class MovieController {

    private MovieService movieService;

    // Create a movie
    @PostMapping
    public Movie createMovie(@RequestBody CreateMovieDTO request){
        return movieService.createMovie(request.toMovie());
    }

    @GetMapping("/{movieId}")
    public Movie getMovies(@PathVariable Long movieId){
        return movieService.getMovie(movieId);
    }


}
