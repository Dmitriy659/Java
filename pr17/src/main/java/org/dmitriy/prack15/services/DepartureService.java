package org.dmitriy.prack15.services;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import org.dmitriy.prack15.entity.Departure;
import org.dmitriy.prack15.entity.PostOffice;
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

    public List<Departure> filterDeparturesByDate(String date) {
        try {
            Session session = factory.getCurrentSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Departure> criteriaQuery = builder.createQuery(Departure.class);
            Root<Departure> root = criteriaQuery.from(Departure.class);

            criteriaQuery.select(root)
                    .where(builder.like(builder.lower(root.get("creationDate")), "%" + date + "%"));

            List<Departure> filteredDepartures = session.createQuery(criteriaQuery).getResultList();
            return filteredDepartures;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
