package org.dmitriy.prack15;

import org.dmitriy.prack15.entity.Departure;
import org.dmitriy.prack15.entity.PostOffice;
import org.dmitriy.prack15.repositories.DepartureRepository;
import org.dmitriy.prack15.services.DepartureService;
import org.dmitriy.prack15.services.EmailService;
import org.dmitriy.prack15.services.PostOfficeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class DepartureTests {
    @Mock
    private DepartureRepository departureRepository;
    @Mock
    private EmailService emailService;

    @Test
    public void getAllTest() {
        Departure departure = new Departure();
        departure.setType("type");
        Departure departure1 = new Departure();
        departure1.setType("type2");
        Mockito.when(departureRepository.findAll()).thenReturn(List.of(departure, departure1));

        DepartureService departureService = new DepartureService(departureRepository, emailService);

        Assertions.assertEquals(2, departureService.getAllDepartures().size());
        Assertions.assertEquals("type", departureService.getAllDepartures().getFirst().getType());
    }

    @Test
    public void saveTest() {
        Departure departure = new Departure();
        departure.setType("type");
        DepartureService departureService = new DepartureService(departureRepository, emailService);
        departureService.addDeparture(departure);
        ArgumentCaptor<Departure> captor = ArgumentCaptor.forClass(Departure.class);
        Mockito.verify(departureRepository).save(captor.capture());
        Departure captured = captor.getValue();
        Assertions.assertEquals("type", captured.getType());
    }
}
