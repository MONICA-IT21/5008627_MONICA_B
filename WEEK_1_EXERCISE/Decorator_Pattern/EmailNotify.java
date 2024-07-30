package Decorator_Pattern;


public class EmailNotify implements Notify {
    @Override
    public void send(String message) {
        System.out.println("Sending Email with message: " + message);
    }
}


