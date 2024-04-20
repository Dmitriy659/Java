package org.dmitriy.prack15.services;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.dmitriy.prack15.entity.Departure;
import org.dmitriy.prack15.entity.PostOffice;
import org.dmitriy.prack15.repositories.PostOfficeRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PostOfficeService {
    private final PostOfficeRepository postOfficeRepository;
    @Autowired
    public PostOfficeService(PostOfficeRepository postOfficeRepository){

        this.postOfficeRepository = postOfficeRepository;
    }

    public String addPost(PostOffice postOffice){
        postOfficeRepository.save(postOffice);
        return "Запись создана";
    }

    public PostOffice getPost(Long id){
        return postOfficeRepository.findById(id).orElse(null);
    }
    public List<PostOffice> getAllPost(){
        return postOfficeRepository.findAll();
    }

    public void removePost(Long id){
        postOfficeRepository.deleteById(id);
    }

    public void addDeparture(Long id, Departure departure) {
        PostOffice postOffice = getPost(id);
        postOffice.AddDeparture(departure);
        departure.setPostOffice(postOffice);
        postOfficeRepository.save(postOffice);
    }


    public List<PostOffice> filterPostOfficesByCity(String city) {
        return postOfficeRepository.findPostOfficesByCityName(city);
    }

}