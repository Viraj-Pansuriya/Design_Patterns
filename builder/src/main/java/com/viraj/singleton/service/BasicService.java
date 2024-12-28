package com.viraj.singleton.service;

import com.viraj.singleton.model.User;
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
