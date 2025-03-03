package models;

public class Booking {
    private final String username;
    private final String type;
    private final String details;
    private final String date;
    private final double price;
    private boolean isPaid;

    // Constructor
    public Booking(String username, String type, String details, String date, double price) {
        this.username = username;
        this.type = type;
        this.details = details;
        this.date = date;
        this.price = price;
        this.isPaid = false; // Default value
    }

    // Getters
    public String getUsername() {
        return username;
    }

    public String getType() {
        return type;
    }

    public String getDetails() {
        return details;
    }

    public String getDate() {
        return date;
    }

    public double getPrice() {
        return price;
    }

    public boolean isPaid() {
        return isPaid;
    }

    // Setter for payment status
    public void setPaid(boolean isPaid) {
        this.isPaid = isPaid;
    }

    @Override
    public String toString() {
        return String.format(
            "[%s] %s - %s | Date: %s | Price: %.2f | Paid: %s",
            type != null ? type : "N/A",
            details != null ? details : "N/A",
            username,
            date != null ? date : "N/A",
            price,
            isPaid ? "Paid" : "Not Paid"
        );
    }
    
}
