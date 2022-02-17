package com.example.movieworkshop.controllers;

import com.example.movieworkshop.services.MovieServices;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.FileNotFoundException;
import java.util.ArrayList;

@RestController
public class MovieController {



    @GetMapping("/") // root endpoint
    public String index(){
        return "This application analyse movies!";
    }

    @GetMapping("/getFirst")
    public String getFirst() throws FileNotFoundException {
        return new MovieServices().getFirst();
    }
    @GetMapping("/getRandom")
    public String getRandom() throws FileNotFoundException {
        return new MovieServices().getRandom();
    }

    @GetMapping("/getTenSortByPopularity")
    public String getTenSortByPopularity() throws FileNotFoundException {
        return  "This is ten random movies sorted by popularity" + new MovieServices().getTenSortByPopularity();
    }

    @GetMapping("/howManyWonAnAward")
    public String howManyWonAnAward() throws FileNotFoundException {
        return new MovieServices().howManyWonAnAward() + " of the movies have won an award!";
    }


    @GetMapping(value = "/filter")
    public String filter(@RequestParam char x, int n) throws FileNotFoundException {
        return "Your filtered movies are: " + new MovieServices().filterCharN(x,n);
    }


    @GetMapping("/length")
    public ArrayList<Integer> service() throws FileNotFoundException {
        return new MovieServices().showMovieLengths();
    }
}
