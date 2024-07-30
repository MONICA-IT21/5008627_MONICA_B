
import java.util.ArrayList;
import java.util.List;

public interface Stock<Observer> {
    void registerObserver(Observer observer);
    void deregisterObserver(Observer observer);
    void notifyObservers();
}
