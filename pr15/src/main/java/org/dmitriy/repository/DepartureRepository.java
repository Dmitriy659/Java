package org.dmitriy.repository;

import org.dmitriy.entity.Departure;
import org.springframework.data.repository.CrudRepository;

public interface DepartureRepository extends CrudRepository<Departure, Long> {
}
