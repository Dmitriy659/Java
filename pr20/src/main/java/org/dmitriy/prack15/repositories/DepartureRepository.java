package org.dmitriy.prack15.repositories;

import org.dmitriy.prack15.entity.Departure;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartureRepository extends JpaRepository<Departure, Long> {
    public List<Departure> findDeparturesByCreationDate(String creationDate);
}
