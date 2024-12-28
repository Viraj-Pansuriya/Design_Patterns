package com.viraj.singleton.Service;

import com.viraj.singleton.model.Dog;
import org.springframework.stereotype.Service;

@Service
public class DummyService {

    private final Dog dog;
    private final DataPrintingService dataPrintingService;

    public DummyService(Dog dog, DataPrintingService dataPrintingService) {
        this.dog = dog;
        this.dataPrintingService = dataPrintingService;
    }

    public void printData() {

        System.out.println("Dog is : " + dog);

        // here we have changed dog name , in data printing service ,
        // we will print injected dog object and can see name will be change.
        dog.setName("pug");
        dataPrintingService.printData();
    }
}
