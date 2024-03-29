package com.movieapp.mbs.exceptions;

public class InvalidCustomerException extends RuntimeException {

    public InvalidCustomerException(){
        super("Email is mandatory");
    }
}
