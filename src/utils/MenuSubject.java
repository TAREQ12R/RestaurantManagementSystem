package utils;

import java.util.ArrayList;
import java.util.List;

public class MenuSubject {
    private final List<MenuObserver> observers = new ArrayList<>();

    public void addObserver(MenuObserver observer) {
        observers.add(observer);
    }

    public void notifyObservers() {
        for (MenuObserver observer : observers) {
            observer.update();
        }
    }
}
