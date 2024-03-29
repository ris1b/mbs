package com.movieapp.mbs.dtos;

import com.movieapp.mbs.enums.Language;
import com.movieapp.mbs.enums.MovieFeature;
import com.movieapp.mbs.models.Movie;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CreateMovieDTO {
    private String name;
    private Double rating;
    private List<Language> languages = new ArrayList<>();
    private List<MovieFeature> features = new ArrayList<>();

    public Movie toMovie(){
        return Movie.builder()
                .name(name)
                .rating(rating)
                .languages(languages)
                .features(features)
                .build();
    }

}
