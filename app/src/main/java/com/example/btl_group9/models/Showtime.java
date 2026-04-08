package com.example.btl_group9.models;

import com.google.firebase.Timestamp;
import java.util.List;

public class Showtime {
    private String showtime_id;
    private String movie_id;
    private String theater_id;
    private Timestamp start_time;
    private double price;
    private List<String> booked_seats;

    public Showtime() {}

    public Showtime(String showtime_id, String movie_id, String theater_id, Timestamp start_time, double price, List<String> booked_seats) {
        this.showtime_id = showtime_id;
        this.movie_id = movie_id;
        this.theater_id = theater_id;
        this.start_time = start_time;
        this.price = price;
        this.booked_seats = booked_seats;
    }

    public String getShowtime_id() { return showtime_id; }
    public void setShowtime_id(String showtime_id) { this.showtime_id = showtime_id; }
    public String getMovie_id() { return movie_id; }
    public void setMovie_id(String movie_id) { this.movie_id = movie_id; }
    public String getTheater_id() { return theater_id; }
    public void setTheater_id(String theater_id) { this.theater_id = theater_id; }
    public Timestamp getStart_time() { return start_time; }
    public void setStart_time(Timestamp start_time) { this.start_time = start_time; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public List<String> getBooked_seats() { return booked_seats; }
    public void setBooked_seats(List<String> booked_seats) { this.booked_seats = booked_seats; }
}
