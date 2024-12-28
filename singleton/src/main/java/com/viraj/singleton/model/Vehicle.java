package com.viraj.singleton.model;

import jakarta.annotation.PostConstruct;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@ToString
public class Vehicle {
    private String name;
    private String type;
    private String price;

    public Vehicle(String name , String type, String price) {
        System.out.println("Vehicle is created");
        this.name = name;
        this.type = type;
        this.price = price;
    }

}
