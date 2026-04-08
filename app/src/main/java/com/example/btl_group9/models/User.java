package com.example.btl_group9.models;

public class User {
    private String uid;
    private String name;
    private String email;
    private String phone;
    private String fcm_token;

    public User() {} // Bắt buộc phải có constructor rỗng cho Firestore

    public User(String uid, String name, String email, String phone, String fcm_token) {
        this.uid = uid;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.fcm_token = fcm_token;
    }

    // Getters và Setters
    public String getUid() { return uid; }
    public void setUid(String uid) { this.uid = uid; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getFcm_token() { return fcm_token; }
    public void setFcm_token(String fcm_token) { this.fcm_token = fcm_token; }
}
