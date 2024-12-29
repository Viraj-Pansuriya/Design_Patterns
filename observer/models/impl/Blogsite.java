package models.impl;

import models.Observer;
import models.Subject;

import java.util.ArrayList;
import java.util.List;

public class Blogsite implements Subject {

    List<Observer> subscribers = new ArrayList<>();
    @Override
    public void subscribe(Observer observer) {
        this.subscribers.add(observer);
    }

    @Override
    public void unsubscribe(Observer observer) {
        this.subscribers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for(Observer observer : subscribers) observer.notified(message);
    }
}
