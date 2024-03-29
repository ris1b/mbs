package com.movieapp.mbs.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 *  Customer : the Client
 *  */
@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer extends BaseModel{
    private String fullName;
    private String city;
    private String phoneNumber;
    private String email;

    @OneToOne
    private User user;

}
