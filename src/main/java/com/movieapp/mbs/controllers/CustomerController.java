package com.movieapp.mbs.controllers;

import com.movieapp.mbs.dtos.CreateCustomerDTO;
import com.movieapp.mbs.exceptions.InvalidCustomerException;
import com.movieapp.mbs.models.Customer;
import com.movieapp.mbs.services.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
@AllArgsConstructor
public class CustomerController {

    private CustomerService customerService;

    // Get a Customer
    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable Long id){
        return customerService.getCustomer(id);
    }

    // Crete a Customer
    @PostMapping
    public Customer createCustomer(@RequestBody CreateCustomerDTO request){
        validate(request);

        return customerService.createCustomer(request);
    }

    private void validate(CreateCustomerDTO request) {
        if(request.getEmail() == null){
            throw new InvalidCustomerException();
        }
    }

    @GetMapping("/name")
    public String greetings(){

        return "Welcome to Movie Booking System !";
    }
}
