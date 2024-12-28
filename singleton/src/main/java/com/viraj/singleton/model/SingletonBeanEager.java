package com.viraj.singleton.model;

// Eager way of creating singleton bean
public class SingletonBeanEager {

    private static SingletonBeanEager singletonBeanEager = new SingletonBeanEager();

    private SingletonBeanEager() {
        System.out.println("SingletonBeanEager is created");
    }

    public static SingletonBeanEager getInstance() {
        return singletonBeanEager;
    }
}
