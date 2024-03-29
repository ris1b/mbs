package com.movieapp.mbs.models;

import com.movieapp.mbs.enums.Language;
import com.movieapp.mbs.enums.MovieFeature;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Movie extends BaseModel {

    private String name;
    private Double rating;

    @ElementCollection
    @Enumerated
    private List<Language> languages = new ArrayList<>();

    @ElementCollection
    @Enumerated
    private List<MovieFeature> features = new ArrayList<>();

    @OneToMany(mappedBy = "movie")
    private List<Show> shows = new ArrayList<>();
}
