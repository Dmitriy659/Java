package org.dmitriy.prack15.services;

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

}