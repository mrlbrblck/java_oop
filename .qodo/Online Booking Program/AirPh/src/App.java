import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.*;
import models.*;
import utils.*;

// Main application class
public class App {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<User> users = Database.loadUsers();
    private static final List<Booking> bookings = Database.loadBookings();
    private static final List<Flight> flights = Database.loadFlights();
    private static final List<Hotel> hotels = Database.loadHotels();
    private static User currentUser;

    public static void main(String[] args) {
        OUTER:
        while (true) {
            System.out.println("\nWelcome to AirPh Booking System");
            System.out.println("1. Sign Up\n2. Log In\n3. Exit");
            System.out.print("Choose an option: ");
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
                continue;
            }
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 -> signUp();
                case 2 -> login();
                case 3 -> {
                    System.out.println("Thank you for using AirPh!");
                    break OUTER;
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void signUp() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        users.add(new User(username, password));
        Database.saveUsers(users);
        System.out.println("Sign-up successful!");
    }

    private static void login() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        
        for (User user : users) {
            if (user.getUsername().equals(username) && user.authenticate(password)) {
                currentUser = user;
                System.out.println("Login successful!");
                userMenu();
                return;
            }
        }
        System.out.println("Invalid credentials.");
    }

    private static void userMenu() {
        OUTER:
        while (true) {
            System.out.println("\n1. Book Flight\n2. Book Hotel\n3. View Bookings\n4. Log Out");
            System.out.print("Choose an option: ");
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
                continue;
            }
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 -> bookFlight();
                case 2 -> bookHotel();
                case 3 -> viewBookings();
                case 4 -> {
                    System.out.println("Logging out...");
                    currentUser = null;
                    break OUTER;
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void bookFlight() {
        System.out.println("\nAvailable Flights:");
        
        if (flights.isEmpty()) {
            System.out.println("No flights available.");
            return;
        }

        // Display flights with departure times
        for (Flight flight : flights) {
            System.out.println(flight.getFlightNumber() + " | " + flight.getAirline() + " | " +
                               flight.getOrigin() + " -> " + flight.getDestination() +
                               " | Departs at: " + flight.getDepartureTime() +
                               " | Price: " + flight.getPrice() +
                               " | Seats Available: " + flight.getSeatsAvailable());
        }

        System.out.print("\nEnter Flight Number to book: ");
        String flightNumber = scanner.nextLine();

        // Find the selected flight
        Flight selectedFlight = flights.stream()
        .filter(f -> f.getFlightNumber() != null && f.getFlightNumber().equalsIgnoreCase(flightNumber))
        .findFirst()
        .orElse(null);

        if (selectedFlight == null) {
            System.out.println("Invalid Flight Number. Please try again.");
            return;
        }

        // Ask for the flight date
        System.out.print("Enter Date of Flight (YYYY-MM-DD): ");
        String flightDate = scanner.nextLine();

        // Ensure there are available seats before booking
        if (selectedFlight.getSeatsAvailable() <= 0) {
            System.out.println("Sorry, this flight is fully booked.");
            return;
        }

        bookings.add(new Booking(currentUser.getUsername(), "Flight",
        selectedFlight.getFlightNumber() + " from " + selectedFlight.getOrigin() + " to " + selectedFlight.getDestination(),
        flightDate, selectedFlight.getPrice()));
    

        Database.saveBookings(bookings);
        Database.saveFlights(flights);

        System.out.println("Flight booked successfully for " + flightDate + "! Enjoy your trip.");
    }

private static void bookHotel() {
    System.out.println("\nAvailable Hotels:");

    if (hotels.isEmpty()) {
        System.out.println("No hotels available.");
        return;
    }

    for (Hotel hotel : hotels) {
        System.out.println(hotel.getHotelId() + " | " + hotel.getName() + " | " +
                           hotel.getLocation() + " | Price per Night: " + hotel.getPricePerNight());
    }

    System.out.print("Enter Hotel ID: ");
    String hotelId = scanner.nextLine();

    Hotel selectedHotel = hotels.stream()
        .filter(h -> h.getHotelId().equals(hotelId))
        .findFirst()
        .orElse(null);

    if (selectedHotel == null) {
        System.out.println("Invalid Hotel ID.");
        return;
    }

    // Get check-in date
    System.out.print("Enter Check-in Date (YYYY-MM-DD): ");
    String checkInDateStr = scanner.nextLine();

    // Get check-out date
    System.out.print("Enter Check-out Date (YYYY-MM-DD): ");
    String checkOutDateStr = scanner.nextLine();

    try {
        LocalDate checkInDate = LocalDate.parse(checkInDateStr);
        LocalDate checkOutDate = LocalDate.parse(checkOutDateStr);

        if (!checkOutDate.isAfter(checkInDate)) {
            System.out.println("Error: Check-out date must be after check-in date.");
            return;
        }

        int nights = (int) ChronoUnit.DAYS.between(checkInDate, checkOutDate);
        double totalCost = selectedHotel.getPricePerNight() * nights;

        bookings.add(new Booking(currentUser.getUsername(), "Hotel",
            selectedHotel.getName() + " in " + selectedHotel.getLocation(),
            checkInDateStr + " to " + checkOutDateStr,  // Store the date range
            totalCost));

        Database.saveBookings(bookings);
        System.out.println("Hotel booked from " + checkInDateStr + " to " + checkOutDateStr +
                           " (" + nights + " nights). Total cost: " + totalCost);

    } catch (DateTimeParseException e) {
        System.out.println("Invalid date format. Please use YYYY-MM-DD.");
    }
}

    private static void viewBookings() {
        if (bookings.isEmpty()) {
            System.out.println("No bookings found.");
            return;
        }

        System.out.println("\nYour Bookings:");
        for (int i = 0; i < bookings.size(); i++) {
            System.out.println((i + 1) + ". " + bookings.get(i));
        }

        System.out.print("Select a booking to pay (or 0 to go back): ");
        int choice = scanner.nextInt();
        scanner.nextLine(); 

        if (choice > 0 && choice <= bookings.size()) {
            makePayment(bookings.get(choice - 1));
        }
    }

    private static void makePayment(Booking booking) {
        if (booking.isPaid()) {
            System.out.println("This booking is already paid.");
            return;
        }

        System.out.println("Processing payment for booking...");
        System.out.print("Enter payment method (Credit Card / PayPal / Bank Transfer): ");
        String method = scanner.nextLine();

        boolean success = PaymentManager.processPayment(booking.getUsername(), booking.getPrice(), method);


        if (success) {
            booking.setPaid(true);  // Update payment status
            Database.saveBookings(bookings);  // Persist the change
            System.out.println("Payment confirmed! Booking updated.");
        } else {
            System.out.println("Payment failed. Please try again.");
        }
    }
}
