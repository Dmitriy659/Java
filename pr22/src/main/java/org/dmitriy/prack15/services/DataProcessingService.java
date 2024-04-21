package org.dmitriy.prack15.services;

import lombok.AllArgsConstructor;
import org.dmitriy.prack15.entity.Departure;
import org.dmitriy.prack15.entity.PostOffice;
import org.dmitriy.prack15.repositories.DepartureRepository;
import org.dmitriy.prack15.repositories.PostOfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Service
@AllArgsConstructor
@ManagedResource(objectName = "org.dmitriy.prack15:type=DataProcessingService")
public class DataProcessingService {

    private final DepartureRepository departureRepository;
    private final PostOfficeRepository postOfficeRepository;

    private final String dataDir = "C:/Users/user/IdeaProjects/pr21/data";

    @Scheduled(fixedDelay = 30 * 60 * 1000)
    public void processData() {
        clearDirectory();
        List<Departure> departures = departureRepository.findAll();
        List<PostOffice> postOffices = postOfficeRepository.findAll();
        saveDeparturesToFiles(departures);
        savePostOfficesToFiles(postOffices);
    }

    private void clearDirectory() {
        File directory = new File(dataDir);
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                file.delete();
            }
        }
        System.out.println("Directory cleared");
    }

    private void saveDeparturesToFiles(List<Departure> departures) {
        for (Departure entity : departures) {
            String fileName = dataDir + "/Departures.txt";
            try (FileWriter writer = new FileWriter(fileName, true)) {
                writer.write(entity.toString() + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Files created and data loaded from database");
    }

    private void savePostOfficesToFiles(List<PostOffice> postOffices) {
        for (PostOffice entity : postOffices) {
            String fileName = dataDir + "/PostOffices.txt";
            try (FileWriter writer = new FileWriter(fileName, true)) {
                writer.write(entity.toString() + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Files created and data loaded from database");
    }

    @ManagedOperation(description = "Process data and save to files")
    public void processDataWithJMX() {
        processData();
    }
}
