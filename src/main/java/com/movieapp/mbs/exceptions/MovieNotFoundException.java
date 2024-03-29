package com.movieapp.mbs.exceptions;

public class MovieNotFoundException extends RuntimeException{
    public MovieNotFoundException(Long movieId) {
        super("Movie not found with id: " + movieId + "****");
    }
}
