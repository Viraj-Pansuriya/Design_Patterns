package com.viraj.singleton.controller;

import com.viraj.singleton.Service.DummyService;
import com.viraj.singleton.Service.DataPrintingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {

    private final DataPrintingService dataPrintingService;
    private final DummyService dummyService;

    public BasicController(DataPrintingService dataPrintingService, DummyService dummyService) {
        this.dataPrintingService = dataPrintingService;
        this.dummyService = dummyService;
    }


    @GetMapping("/data")
    public void printData() {

        // here I have injected dataPrinting Service , and will also inject in dummy service
        // we can see that dataPrinting Service will be created only once, while starting application.

        dummyService.printData();

    }



}
