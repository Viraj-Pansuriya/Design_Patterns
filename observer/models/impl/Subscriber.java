package models.impl;

import models.Observer;

public class Subscriber implements Observer {

    private String name;

    public Subscriber(String name) {
        this.name = name;
    }

    @Override
    public void notified(String message) {
        System.out.println("Hii " + name + ", " +  message);
    }
}
