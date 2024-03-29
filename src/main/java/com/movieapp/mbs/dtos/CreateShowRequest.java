package com.movieapp.mbs.dtos;

import com.movieapp.mbs.enums.Language;
import lombok.Data;

import java.util.Date;

@Data
public class CreateShowRequest {
    private Long hallId;
    private Long movieId;
    private Date startTime;
    private Language language;
}
