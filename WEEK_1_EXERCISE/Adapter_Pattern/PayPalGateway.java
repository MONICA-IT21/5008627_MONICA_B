package Adapter_Pattern;

public class PayPalGateway {
    public void pay(double amount) {
        System.out.println("Processing the payment through PayPal Gateway: $" + amount);
    }
}
