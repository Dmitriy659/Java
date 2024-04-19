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
public class PostOfficeService {
    private final SessionFactory factory;
    @Autowired
    public PostOfficeService(SessionFactory factory){
        this.factory = factory;
    }

    public String addPost(PostOffice postOffice){
        System.out.println(postOffice);
        try {
            Session session = factory.getCurrentSession();
            session.save(postOffice);
            return "Запись создана";
        } catch (Exception e){
            return e.getMessage();
        }
    }

    public PostOffice getPost(Long id){
        PostOffice postOffice = null;
        try {
            Session session = factory.getCurrentSession();
            postOffice = session.get(PostOffice.class, id);
        }
        catch (Exception e){
            return null;
        }
        return postOffice;

    }
    public List<PostOffice> getAllPost(){
        try {
            Session session = factory.getCurrentSession();
            Query<PostOffice> query = session.createQuery("FROM PostOffice ", PostOffice.class);
            return query.list();
        }
        catch (Exception e){
            return null;
        }
    }

    public Boolean removePost(Long id){
        try {
            Session session = factory.getCurrentSession();
            session.createQuery("DELETE FROM PostOffice WHERE id = :postofficeId")
                    .setParameter("postofficeId", id).executeUpdate();
        }
        catch (Exception e){
            return false;
        }
        return true;
    }

    public void addDeparture(Long id, Departure departure) {
        Session session = factory.getCurrentSession();
        PostOffice postOffice = getPost(id);
        postOffice.AddDeparture(departure);
        session.save(departure);
    }

    public List<PostOffice> filterPostOfficesByCity(String city) {
        try {
            Session session = factory.getCurrentSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<PostOffice> criteriaQuery = builder.createQuery(PostOffice.class);
            Root<PostOffice> root = criteriaQuery.from(PostOffice.class);

            criteriaQuery.select(root)
                    .where(builder.like(builder.lower(root.get("cityName")), "%" + city.toLowerCase() + "%"));

            List<PostOffice> filteredPostOffices = session.createQuery(criteriaQuery).getResultList();
            return filteredPostOffices;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}