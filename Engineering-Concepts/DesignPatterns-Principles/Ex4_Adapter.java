interface PaymentProcessor {
    void processPayment();
}

class PayPalGateway {
    public void makePayment() {
        System.out.println("Payment processed using PayPal");
    }
}

class PayPalAdapter implements PaymentProcessor {

    private PayPalGateway gateway;

    public PayPalAdapter(PayPalGateway gateway) {
        this.gateway = gateway;
    }

    public void processPayment() {
        gateway.makePayment();
    }
}

public class Ex4_Adapter {
    public static void main(String[] args) {

        PaymentProcessor processor =
                new PayPalAdapter(new PayPalGateway());

        processor.processPayment();
    }
}