package com.example.btl_group9.models;

import com.google.firebase.Timestamp;
import java.util.List;

public class Ticket {
    private String ticket_id;
    private String user_id;
    private String showtime_id;
    private List<String> seat_numbers;
    private String status; // "paid", "cancelled"
    private Timestamp created_at;

    public Ticket() {}

    public Ticket(String ticket_id, String user_id, String showtime_id, List<String> seat_numbers, String status, Timestamp created_at) {
        this.ticket_id = ticket_id;
        this.user_id = user_id;
        this.showtime_id = showtime_id;
        this.seat_numbers = seat_numbers;
        this.status = status;
        this.created_at = created_at;
    }

    public String getTicket_id() { return ticket_id; }
    public void setTicket_id(String ticket_id) { this.ticket_id = ticket_id; }
    public String getUser_id() { return user_id; }
    public void setUser_id(String user_id) { this.user_id = user_id; }
    public String getShowtime_id() { return showtime_id; }
    public void setShowtime_id(String showtime_id) { this.showtime_id = showtime_id; }
    public List<String> getSeat_numbers() { return seat_numbers; }
    public void setSeat_numbers(List<String> seat_numbers) { this.seat_numbers = seat_numbers; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public Timestamp getCreated_at() { return created_at; }
    public void setCreated_at(Timestamp created_at) { this.created_at = created_at; }
}
