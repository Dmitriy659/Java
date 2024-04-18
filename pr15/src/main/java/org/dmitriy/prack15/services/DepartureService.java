package org.dmitriy.prack15.services;

import jakarta.transaction.Transactional;
import org.dmitriy.prack15.entity.Departure;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Transactional
public class DepartureService {
    private final SessionFactory factory;
    @Autowired
    public DepartureService(SessionFactory factory){
        this.factory = factory;
    }

    public String addDeparture(Departure departure){
        System.out.println(departure);
        try {
            Session session = factory.getCurrentSession();
            session.save(departure);
            return "Запись создана";
        } catch (Exception e){
            return e.getMessage();
        }
    }

    public Departure getDeparture(Long id){
        Departure departure = null;
        try {
            Session session = factory.getCurrentSession();
            departure = session.get(Departure.class, id);
        }
        catch (Exception e){
            return null;
        }
        return departure;

    }
    public List<Departure> getAllDepartures(){
        try {
            Session session = factory.getCurrentSession();
            Query<Departure> query = session.createQuery("FROM Departure", Departure.class);
            return query.list();
        }
        catch (Exception e){
            return null;
        }
    }

    public Boolean removeDeparture(Long id){
        try {
            Session session = factory.getCurrentSession();
            session.createQuery("DELETE FROM Departure WHERE id = :departureId")
                    .setParameter("departureId", id).executeUpdate();
        }
        catch (Exception e){
            return false;
        }
        return true;
    }

}
