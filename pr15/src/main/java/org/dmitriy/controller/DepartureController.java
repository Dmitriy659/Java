package org.dmitriy.controller;

import org.dmitriy.entity.Departure;
import org.dmitriy.repository.DepartureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/departure")
public class DepartureController {
    private DepartureRepository departureRepository;

    @Autowired
    public DepartureController(DepartureRepository departureRepository) {
        this.departureRepository = departureRepository;
    }

    @GetMapping("/get")
    @ResponseBody
    public String getAll() {
        Iterable<Departure> departures = departureRepository.findAll();

        return departures.toString();
    }

    @GetMapping("/get/{id}")
    @ResponseBody
    public String get(@PathVariable int id) {
        Optional<Departure> d = departureRepository.findById((long)id);
        Departure departure = d.get();
        return departure.toString();
    }

    @PostMapping("/add")
    @ResponseBody
    public String add(@RequestBody Departure departure) {
        departureRepository.save(departure);
        return "Add departure with id: " + departure.getId();
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public String delete(@PathVariable int id) {
        departureRepository.deleteById((long) id);
        return "Object with id: " + id + " was deleted!";
    }
}
