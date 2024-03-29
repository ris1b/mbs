package com.movieapp.mbs.models;

import com.movieapp.mbs.enums.BookingStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Entity
public class Booking extends BaseModel {
    @ManyToOne
    private Customer customer;

    @ManyToOne
    private Show show;

    private Double amount;
    private Date bookedAt;

    @Enumerated
    private BookingStatus status;

    @ManyToMany
    private List<ShowSeat> seats = new ArrayList<>();

//    private List<Payment> payments = new ArrayList<>();
}
