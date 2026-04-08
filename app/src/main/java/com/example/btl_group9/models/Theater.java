package com.example.btl_group9.models;

import java.util.List;

public class Theater {
    private String theater_id;
    private String name;
    private String location;
    private List<Room> rooms;

    public Theater() {}

    public static class Room {
        private String room_name;
        private int capacity;

        public Room() {}
        public Room(String room_name, int capacity) {
            this.room_name = room_name;
            this.capacity = capacity;
        }
        public String getRoom_name() { return room_name; }
        public void setRoom_name(String room_name) { this.room_name = room_name; }
        public int getCapacity() { return capacity; }
        public void setCapacity(int capacity) { this.capacity = capacity; }
    }

    public Theater(String theater_id, String name, String location, List<Room> rooms) {
        this.theater_id = theater_id;
        this.name = name;
        this.location = location;
        this.rooms = rooms;
    }

    public String getTheater_id() { return theater_id; }
    public void setTheater_id(String theater_id) { this.theater_id = theater_id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    public List<Room> getRooms() { return rooms; }
    public void setRooms(List<Room> rooms) { this.rooms = rooms; }
}
