package com.example.btl_group9.models;

public class Movie {
    private String movie_id;
    private String title;
    private String description;
    private String poster_url;
    private int duration;
    private double rating;

    public Movie() {}

    public Movie(String movie_id, String title, String description, String poster_url, int duration, double rating) {
        this.movie_id = movie_id;
        this.title = title;
        this.description = description;
        this.poster_url = poster_url;
        this.duration = duration;
        this.rating = rating;
    }

    public String getMovie_id() { return movie_id; }
    public void setMovie_id(String movie_id) { this.movie_id = movie_id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getPoster_url() { return poster_url; }
    public void setPoster_url(String poster_url) { this.poster_url = poster_url; }
    public int getDuration() { return duration; }
    public void setDuration(int duration) { this.duration = duration; }
    public double getRating() { return rating; }
    public void setRating(double rating) { this.rating = rating; }
}
