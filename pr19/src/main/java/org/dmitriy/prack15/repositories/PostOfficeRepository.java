package org.dmitriy.prack15.repositories;

import org.dmitriy.prack15.entity.PostOffice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostOfficeRepository extends JpaRepository<PostOffice, Long> {
    public List<PostOffice> findPostOfficesByCityName(String cityName);
}
