package org.dmitriy.prack15.services;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dmitriy.prack15.entity.Departure;
import org.dmitriy.prack15.repositories.DepartureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@Transactional
@AllArgsConstructor
public class DepartureService {
    private final DepartureRepository departureRepository;
    private final EmailService emailService;

    public String addDeparture(Departure departure){
        departureRepository.save(departure);
        emailService.sendEmail("example@gmail.com", "Object creating", departure.toString());
        return "Запись создана";
    }

    public Departure getDeparture(Long id){
        Departure departure = departureRepository.findById(id).orElse(null);
        return departure;

    }
    public List<Departure> getAllDepartures(){
        return departureRepository.findAll();
    }

    public void removeDeparture(Long id){
        departureRepository.deleteById(id);
    }

    public List<Departure> filterDeparturesByDate(String date) {
        return departureRepository.findDeparturesByCreationDate(date);
    }

}
