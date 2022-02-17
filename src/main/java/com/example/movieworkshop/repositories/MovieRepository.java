package com.example.movieworkshop.repositories;

import com.example.movieworkshop.models.Movie;
import org.springframework.stereotype.Repository;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class MovieRepository {
    private HashSet<Movie> movieHashSet = new HashSet<Movie>();
    private ArrayList<Movie> movieArrayList = new ArrayList<Movie>();
    Movie movie = new Movie(0,0,"tile","subject",0,"0");
    // this class should read data file  & create movie objects of the data




    public MovieRepository() throws FileNotFoundException {
        movieDataReader();
    }

    public Movie movieDataReader() throws FileNotFoundException {
        FileReader fileReader = new FileReader("src/main/resources/data/imdb-data.csv");
        Scanner scanner = new Scanner(fileReader);
        scanner.nextLine();

        while (scanner.hasNextLine()) {
            String[] movieDatas = scanner.nextLine().split(";");
            int movieYear = (Integer.parseInt(movieDatas[0]));
            int movieLength = (Integer.parseInt(movieDatas[1]));
            String movieTitle = (movieDatas[2]);
            String movieSubject = (movieDatas[3]);
            int moviePopularity = (Integer.parseInt(movieDatas[4]));
            String hasMovieAwards = (movieDatas[5]);
            movie = new Movie(movieYear,movieLength,movieTitle,movieSubject,moviePopularity,hasMovieAwards);
            movieHashSet.add(movie);
            movieArrayList.add(movie);
        }
        return movie;
    }


    public HashSet<Movie> getMovieHashSet() {
        return movieHashSet;
    }

    public ArrayList<Movie> getMovieArrayList() {
        return movieArrayList;
    }
}
