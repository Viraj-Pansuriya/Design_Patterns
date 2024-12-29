package com.viraj.builder.service;

import com.viraj.builder.model.User;
import org.springframework.stereotype.Service;

@Service
public class BasicService {

    public void printUser(){

        User user = new  User.UserBuilder()
                .setAddress("address")
                .setAge(10)
                .setCity("city")
                .setName("name")
                .build();


        System.out.println("user = " + user);



    }

}
