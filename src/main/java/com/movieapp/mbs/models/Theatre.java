package com.movieapp.mbs.models;

import jakarta.persistence.Entity;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Theatre is similar to a Cinema.
 * Can be used interchangeably.
 */
//@Entity
@Getter
@Setter
@Entity
public class Theatre extends BaseModel{

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    private String name;
    private String address;

    @OneToMany
    private List<Hall> screens = new ArrayList<>();

//    @OneToMany // this is redundancy. mapping should be there between Screen and Shows and not between Theatre and Shows.
//    private List<Show> shows = new ArrayList<>();
}
