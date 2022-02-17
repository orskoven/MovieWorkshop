package com.example.movieworkshop.services;


import com.example.movieworkshop.models.Movie;
import com.example.movieworkshop.repositories.MovieRepository;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;

public class MovieServices {
    MovieRepository movieRepository = new MovieRepository();
    ArrayList<Movie> movieArrayList = movieRepository.getMovieArrayList();
    HashSet<Movie> movieHashSet = movieRepository.getMovieHashSet();
    Random random = new Random();


    public MovieServices() throws FileNotFoundException {
    }


    public String getFirst() {
        return "The first on the list is: " + movieRepository.getMovieArrayList().get(0).getTitle();

    }

    public String getRandom() {
        return "A random on the list is: " + movieRepository.
                getMovieArrayList().get(random.nextInt(movieRepository.getMovieArrayList().size())).getTitle();
    }

    public ArrayList<String> getTenSortByPopularity(){
        ArrayList<String> tenSortedByPopularity = new ArrayList<String>();
        int counter = 0;
            for (Movie sortedByPop :movieArrayList)
            {
                while (counter < 10) {
                    sortedByPop = movieArrayList.get(random.nextInt(movieArrayList.size()));
                    tenSortedByPopularity.add(sortedByPop.getTitle());
                    counter++;
                }
        }
        Collections.sort(tenSortedByPopularity);
            Collections.reverse(tenSortedByPopularity);
        return tenSortedByPopularity;
    }

    public int howManyWonAnAward(){
        int counter = 0;
        for (Movie awardWinner:movieHashSet
             ) {
            if (awardWinner.isHasWonAwards()) counter++;
        }
        return counter;
    }

    public ArrayList<String> filterCharN(char x,int n){
        ArrayList<String> filteredList = new ArrayList<String>();
        for (Movie filter:movieArrayList
             ) {
            int charCounter = 0;
            String filters = filter.getTitle().split(",")[0];
            if (filters.contains(String.valueOf(x))) {
                for (int i = 0; i < filters.length(); i++) {
                    if (filters.charAt(i) == x) {
                        charCounter++;
                    }
                }
                if (charCounter == n) {
                    filteredList.add(filters);
                }
                charCounter = 0;
            }
        }
        return filteredList;

    }


    public ArrayList<Integer> showMovieLengths() throws FileNotFoundException {
        ArrayList<Integer> movieLengths = new ArrayList<Integer>();
        for (Movie movieLength:movieRepository.getMovieHashSet()
             ) {
            movieLengths.add(movieLength.getLength());
        }
        return movieLengths;



    }

}
