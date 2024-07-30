package Decorator_Pattern;


public abstract class NotifierDecorator implements Notify {
    protected Notify wrappedNotifier;

    public NotifierDecorator(Notify notifier) {
        this.wrappedNotifier = notifier;
    }

    @Override
    public void send(String message) {
        wrappedNotifier.send(message);
    }
}
