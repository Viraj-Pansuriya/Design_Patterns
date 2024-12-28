package com.viraj.singleton.model;

import jakarta.annotation.PostConstruct;
import lombok.*;

@Data
@ToString
@Getter
@Setter
public class Dog {
    private String name;
    private String price;

    public Dog(String name , String price) {
        this.name = name;
        this.price = price;
    }

    @PostConstruct
    public void init() {
        System.out.println("Dog is created");
    }
}
