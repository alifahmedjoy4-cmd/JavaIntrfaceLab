abstract class Payment {

    static int counter = 1;

    String generateTransactionId() {
        return "TXN" + counter++;
    }

    void validateAccountDetails() {
        System.out.println("Account details validated.");
    }

    abstract void authorize(double amount);

    abstract void processPayment(double amount);

    abstract String generateReceipt();
}

interface Refundable {
    void refund(double amount);
}

interface RecurringBillable {
    void setupRecurringPayment(double amount);
}

interface LoyaltyPointsEarner {
    void earnPoints(int points);
}

class CreditCardPayment extends Payment
        implements Refundable, RecurringBillable, LoyaltyPointsEarner {

    public void authorize(double amount) {
        System.out.println("Credit Card authorized: $" + amount);
    }

    public void processPayment(double amount) {
        validateAccountDetails();
        System.out.println("Credit Card payment processed: $" + amount);
    }

    public String generateReceipt() {
        return "Receipt ID: " + generateTransactionId();
    }

    public void refund(double amount) {
        System.out.println("Refunded $" + amount + " to Credit Card");
    }

    public void setupRecurringPayment(double amount) {
        System.out.println("Recurring Credit Card payment: $" + amount);
    }

    public void earnPoints(int points) {
        System.out.println(points + " loyalty points earned");
    }
}

class PayPalPayment extends Payment
        implements Refundable, RecurringBillable, LoyaltyPointsEarner {

    public void authorize(double amount) {
        System.out.println("PayPal authorized: $" + amount);
    }

    public void processPayment(double amount) {
        System.out.println("PayPal payment processed: $" + amount);
    }

    public String generateReceipt() {
        return "Receipt ID: " + generateTransactionId();
    }

    public void refund(double amount) {
        System.out.println("Refunded $" + amount + " to PayPal");
    }

    public void setupRecurringPayment(double amount) {
        System.out.println("Recurring PayPal payment: $" + amount);
    }

    public void earnPoints(int points) {
        System.out.println(points + " loyalty points earned");
    }
}

class BankTransferPayment extends Payment {

    public void authorize(double amount) {
        System.out.println("Bank Transfer authorized: $" + amount);
    }

    public void processPayment(double amount) {
        validateAccountDetails();
        System.out.println("Bank Transfer processed: $" + amount);
    }

    public String generateReceipt() {
        return "Receipt ID: " + generateTransactionId();
    }
}

class CryptoPayment extends Payment {

    public void authorize(double amount) {
        System.out.println("Crypto authorized: $" + amount);
    }

    public void processPayment(double amount) {
        System.out.println("Crypto payment processed: $" + amount);
    }

    public String generateReceipt() {
        return "Receipt ID: " + generateTransactionId();
    }
}

public class Main {

    public static void main(String[] args) {

        CreditCardPayment card = new CreditCardPayment();
        PayPalPayment paypal = new PayPalPayment();
        BankTransferPayment bank = new BankTransferPayment();
        CryptoPayment crypto = new CryptoPayment();

        System.out.println("----- Credit Card -----");
        card.authorize(1000);
        card.processPayment(1000);
        System.out.println(card.generateReceipt());
        card.refund(200);
        card.setupRecurringPayment(500);
        card.earnPoints(100);

        System.out.println();

        System.out.println("----- PayPal -----");
        paypal.authorize(800);
        paypal.processPayment(800);
        System.out.println(paypal.generateReceipt());
        paypal.refund(100);
        paypal.setupRecurringPayment(300);
        paypal.earnPoints(80);

        System.out.println();

        System.out.println("----- Bank Transfer -----");
        bank.authorize(5000);
        bank.processPayment(5000);
        System.out.println(bank.generateReceipt());

        System.out.println();

        System.out.println("----- Crypto -----");
        crypto.authorize(1200);
        crypto.processPayment(1200);
        System.out.println(crypto.generateReceipt());
    }
}