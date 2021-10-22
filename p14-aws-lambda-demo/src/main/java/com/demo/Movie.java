package com.demo;

public class Movie {

    private int id;
    private String title;
    private String director;
    private double rating;
    

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return this.director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public double getRating() {
        return this.rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", title='" + getTitle() + "'" +
            ", director='" + getDirector() + "'" +
            ", rating='" + getRating() + "'" +
            "}";
    }

    public Movie() {
    }

    public Movie(int id, String title, String director, double rating) {
        this.id = id;
        this.title = title;
        this.director = director;
        this.rating = rating;
    }

}
