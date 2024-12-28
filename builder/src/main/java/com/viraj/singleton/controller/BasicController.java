package com.viraj.singleton.controller;

import com.viraj.singleton.service.BasicService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {


    private final BasicService basicService;

    public BasicController(BasicService basicService) {
        this.basicService = basicService;
    }


    @GetMapping("/user")
    public void printUser(){
        basicService.printUser();
    }
}
