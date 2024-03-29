package com.movieapp.mbs.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name= "cities")
public class City extends BaseModel {

    private String name;

    @OneToMany(mappedBy = "city")
    private List<Theatre> theatres = new ArrayList<>();
}
