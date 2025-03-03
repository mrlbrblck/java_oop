package utils;

import models.*;
import java.io.*;
import java.util.*;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

// Database class for handling JSON file operations
public class Database {
    private static final String USERS_FILE = "data/users.json";
    private static final String FLIGHTS_FILE = "data/flights.json";
    private static final String HOTELS_FILE = "data/hotels.json";
    private static final String BOOKINGS_FILE = "data/bookings.json";   
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static List<User> loadUsers() {
        return loadFromFile(USERS_FILE, new TypeToken<List<User>>() {});
    }
    
    public static List<Flight> loadFlights() {
        return loadFromFile(FLIGHTS_FILE, new TypeToken<List<Flight>>() {});
    }
    
    public static List<Hotel> loadHotels() {
        return loadFromFile(HOTELS_FILE, new TypeToken<List<Hotel>>() {});
    }
    
    public static List<Booking> loadBookings() {
        return loadFromFile(BOOKINGS_FILE, new TypeToken<List<Booking>>() {});
    }

    public static void saveUsers(List<User> users) {
        saveToFile(USERS_FILE, users);
    }

    public static void saveFlights(List<Flight> flights) {
        saveToFile(FLIGHTS_FILE, flights);
    }

    public static void saveHotels(List<Hotel> hotels) {
        saveToFile(HOTELS_FILE, hotels);
    }

    public static void saveBookings(List<Booking> bookings) {
        saveToFile(BOOKINGS_FILE, bookings);
    }
    
    private static <T> List<T> loadFromFile(String fileName, TypeToken<List<T>> typeToken) {
        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println("File not found: " + fileName + ". Creating a new one.");
            saveToFile(fileName, new ArrayList<T>()); // Create empty file
        }

        try (Reader reader = new FileReader(file)) {
            List<T> data = gson.fromJson(reader, typeToken.getType());
            System.out.println("Loaded " + (data != null ? data.size() : 0) + " items from " + fileName);
            return data != null ? data : new ArrayList<>();
        } catch (IOException e) {
            System.out.println("Error reading file: " + fileName + " - " + e.getMessage());
            return new ArrayList<>();
        }
    }
    
    private static <T> void saveToFile(String fileName, List<T> data) {
        try (Writer writer = new FileWriter(fileName)) {
            gson.toJson(data, writer);
        } catch (IOException e) {
            System.out.println("Error saving to file: " + fileName);
            e.printStackTrace();
        }
    }
}
