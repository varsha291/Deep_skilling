interface PaymentStrategy {
    void pay(int amount);
}

class CreditCardPayment implements PaymentStrategy {

    public void pay(int amount) {
        System.out.println("Paid Rs." + amount + " using Credit Card");
    }
}

class PayPalPayment implements PaymentStrategy {

    public void pay(int amount) {
        System.out.println("Paid Rs." + amount + " using PayPal");
    }
}

class PaymentContext {

    private PaymentStrategy strategy;

    public PaymentContext(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void executePayment(int amount) {
        strategy.pay(amount);
    }
}

public class Ex8_Strategy {
    public static void main(String[] args) {

        PaymentContext creditCard =
                new PaymentContext(new CreditCardPayment());

        creditCard.executePayment(5000);

        PaymentContext paypal =
                new PaymentContext(new PayPalPayment());

        paypal.executePayment(2500);
    }
}