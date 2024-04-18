package org.dmitriy.prack15.controllers;

import org.dmitriy.prack15.entity.Departure;
import org.dmitriy.prack15.services.DepartureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departure")
public class DepartureController {
    DepartureService departureService;
    @Autowired
    public DepartureController(DepartureService departureService) {
        this.departureService = departureService;
    }

    @PostMapping("/create")
    public String createDeparture(@RequestBody Departure departure) {
        return departureService.addDeparture(departure);
    }

    @GetMapping("/getall")
    public String getAllDeparture() {
        return departureService.getAllDepartures().toString();
    }

    @GetMapping("/get/{id}")
    public String getOne(@PathVariable Long id) {
        return departureService.getDeparture(id).toString();
    }

    @PostMapping("/delete/{id}")
    public void deleteDeparture(@PathVariable Long id) {
        departureService.removeDeparture(id);
    }
}
