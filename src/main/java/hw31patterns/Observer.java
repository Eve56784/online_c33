package hw31patterns;

import java.util.ArrayList;
import java.util.List;

interface LanguageObserver {
    void update(String event);
}

public class Observer {
    public static void main(String[] args) {
        LanguageEventNotifier notifier = new LanguageEventNotifier();
        EventLogger logger = new EventLogger();
        AlertSystem alertSystem = new AlertSystem();

        notifier.addObserver(logger);
        notifier.addObserver(alertSystem);
        notifier.notifyObservers("Simplified Chinese translation was completed");
        notifier.removeObserver(alertSystem);
        notifier.notifyObservers("New word added to the dictionary");
    }
}

class LanguageEventNotifier {
    private List<LanguageObserver> observers = new ArrayList<>();

    public void addObserver(LanguageObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(LanguageObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers(String event) {
        for (LanguageObserver observer : observers) {
            observer.update(event);
        }
    }
}

class EventLogger implements LanguageObserver {
    @Override
    public void update(String event) {
        System.out.println("Logging event: " + event);
    }
}

class AlertSystem implements LanguageObserver {
    @Override
    public void update(String event) {
        System.out.println("Alert: Important update - " + event);
    }
}
