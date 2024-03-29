package com.movieapp.mbs.controllers;

import com.movieapp.mbs.dtos.CreateShowRequest;
import com.movieapp.mbs.models.Show;
import com.movieapp.mbs.services.ShowService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shows")
public class ShowController {

    private ShowService showService;

    @GetMapping("/show/{id}")
    public Show readShow(@PathVariable Long id){
        return showService.getShow(id);
    }

    @PostMapping()
    public Show createShow(@RequestBody CreateShowRequest show){
        // TODO : Start time validation
        return showService.createShow(show);
    }
}
