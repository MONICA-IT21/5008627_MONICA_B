package Adapter_Pattern;

public class StripeGateway {
    public void charge(double amount) {
        System.out.println("Charging payment through Stripe: $" + amount);
    }
}

