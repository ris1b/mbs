package com.movieapp.mbs.exceptions;

public class MovieDoesNotExistException extends RuntimeException {
    public MovieDoesNotExistException(String name) {
        super("Movie missing !!!");
    }
}
