package com.movieapp.mbs.exceptions;

public class MovieAlreadyExistsException extends RuntimeException {
    public MovieAlreadyExistsException(String movieName) {
        super(movieName + " already exists !!");
    }
}
