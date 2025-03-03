package models;

public class Payment {
    private String username;
    private double amount;
    private String paymentMethod;
    private boolean isSuccessful;

    // Constructor for new payment (default: not successful)
    public Payment(String username, double amount, String paymentMethod) {
        this.username = username;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.isSuccessful = false;
    }

    // Constructor for payments with predefined status
    public Payment(String username, double amount, String paymentMethod, boolean isSuccessful) {
        this.username = username;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.isSuccessful = isSuccessful;
    }

    public String getUsername() { return username; }
    public double getAmount() { return amount; }
    public String getPaymentMethod() { return paymentMethod; }
    public boolean isSuccessful() { return isSuccessful; }

    public boolean processPayment() {
        if (amount <= 0) {
            System.out.println("Payment failed: Invalid amount.");
            return false;
        }
        
        if (paymentMethod == null || paymentMethod.isEmpty()) {
            System.out.println("Payment failed: No payment method provided.");
            return false;
        }

        // Simulating successful payment
        this.isSuccessful = true;
        System.out.println("Payment of " + amount + " via " + paymentMethod + " was successful.");
        return true;
    }

    @Override
    public String toString() {
        return "Payment Details:\n" +
                "  - Username: " + username + "\n" +
                "  - Amount: " + amount + "\n" +
                "  - Payment Method: " + paymentMethod + "\n" +
                "  - Status: " + (isSuccessful ? "Successful" : "Pending");
    }
}
