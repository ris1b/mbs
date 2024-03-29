package com.movieapp.mbs.services;

import com.movieapp.mbs.dtos.CreateCustomerDTO;
import com.movieapp.mbs.exceptions.CustomerNotFoundException;
import com.movieapp.mbs.exceptions.EmailAlreadyExistsException;
import com.movieapp.mbs.models.Customer;
import com.movieapp.mbs.models.User;
import com.movieapp.mbs.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerService {

    private CustomerRepository customerRepository;
    private UserService userService;

    public Customer getCustomer(Long id) {
         return customerRepository
                 .findById(id)
                 .orElseThrow( () -> new CustomerNotFoundException(id));
    }

    public Customer getCustomerIntenal(Long id) {
        return customerRepository
                .findById(id)
                .orElse(null);
    }

    public Customer createCustomer(CreateCustomerDTO request) {
        // Validate if the email is not present
        // If present, throw an error
        String email = request.getEmail();

        Optional<Customer> existingCustomer = customerRepository.findCustomerByEmail(request.getEmail());
        if(existingCustomer.isPresent()){
            throw new EmailAlreadyExistsException(email);
        }

        // Create the user
        User user = userService.createUser(request.getUsername(), request.getPassword());

        // Create the customer
        Customer customer = Customer.builder()
                .city(request.getCity())
                .email(request.getEmail())
                .phoneNumber(request.getPhoneNumber())
                .fullName(request.getFullName())
                .user(user)
                .build();

        return customerRepository.save(customer);
    }
}
