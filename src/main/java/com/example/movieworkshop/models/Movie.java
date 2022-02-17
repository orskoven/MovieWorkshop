package com.example.movieworkshop.models;

public class Movie implements Comparable<Movie> {

    private int year;
    private int length;
    private String title;
    private String subject;
    private int popularity;
    private boolean hasWonAwards;

    public Movie(int year, int length, String title, String subject, int popularity, String hasWonAwards) {
        this.year = year;
        this.length = length;
        this.title = title;
        this.subject = subject;
        this.popularity = popularity;
        if (hasWonAwards.equals("Yes")) {
            this.hasWonAwards = true;
        } else {
            this.hasWonAwards = false;
        }
    }

        public int getYear () {
            return year;
        }

        public void setYear ( int year){
            this.year = year;
        }

        public int getLength () {
            return length;
        }

        public void setLength ( int length){
            this.length = length;
        }

        public String getTitle () {
            return title;
        }

        public void setTitle (String title){
            this.title = title;
        }

        public String getSubject () {
            return subject;
        }

        public void setSubject (String subject){
            this.subject = subject;
        }

        public int getPopularity () {
            return popularity;
        }

        public void setPopularity ( int popularity){
            this.popularity = popularity;
        }

        public boolean isHasWonAwards () {
            return hasWonAwards;
        }

        public void setHasWonAwards ( boolean hasWonAwards){
            this.hasWonAwards = hasWonAwards;
        }

    @Override
    public int compareTo(Movie o) {
        if (o.popularity > popularity){
            return 1;
        } else if (popularity > o.popularity) {
            return -1;
        } else {
            return 0;
        }
    }

}
