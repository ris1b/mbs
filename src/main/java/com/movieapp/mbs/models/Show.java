package com.movieapp.mbs.models;

import com.movieapp.mbs.enums.Language;
import jakarta.persistence.*;
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
@Table(name = "shows")
public class Show extends BaseModel {
    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    private Date startTime;
    private Integer duration;

    @OneToMany(mappedBy = "show")
    private List<ShowSeat> showSeats = new ArrayList<>();

    @ManyToOne
    private Hall hall;

    @Enumerated
    private Language language;
}
