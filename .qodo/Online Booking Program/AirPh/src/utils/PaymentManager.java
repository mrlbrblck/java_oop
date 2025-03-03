package utils;

import java.util.ArrayList;
import java.util.List;
import models.Payment;

public class PaymentManager {
    private static final List<Payment> payments = new ArrayList<>();

    public static boolean processPayment(String username, double amount, String paymentMethod) {
        Payment payment = new Payment(username, amount, paymentMethod);
        boolean success = payment.processPayment();
        
        if (success) {
            payments.add(payment);  // Store successful payments
        }
        
        return success;
    }

    public static List<Payment> getPayments() {
        return payments;
    }
}
