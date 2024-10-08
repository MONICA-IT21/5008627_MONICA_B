package Adapter_Pattern;

public class AdapterPatternTest {
    public static void main(String[] args) {
     
        PayPalGateway payPalGateway = new PayPalGateway();

        PaymentProcessor payPalAdapter = new PayPalAdapter(payPalGateway);

        payPalAdapter.processPayment(100.0);

        StripeGateway stripeGateway = new StripeGateway();

        PaymentProcessor stripeAdapter = new StripeAdapter(stripeGateway);
        
        stripeAdapter.processPayment(150.0);
    }
}

