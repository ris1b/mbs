package com.movieapp.mbs.exceptions;

public class CustomerNotFoundException extends RuntimeException {

    public CustomerNotFoundException(Long id){
        super("Customer with id: " + id + " not found !!");
    }
}
