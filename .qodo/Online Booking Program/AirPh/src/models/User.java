package models;

import java.util.*;
// User class handling authentication
public class User {
    private String username;
    private String password;
    private List<Booking> bookings;
    
    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.bookings = new ArrayList<>();
    }
    
    public String getUsername() { return username; }
    public boolean authenticate(String password) { return this.password.equals(password); }
    public void addBooking(Booking booking) { bookings.add(booking); }
    public List<Booking> getBookings() { return bookings; }
}
