package com.gut.practice.service;

import com.gut.practice.entity.file.News;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityExistsException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author kongo
 */

@Stateless
@SessionScoped
public class NewsService extends BaseService<News> {
    @Override
    public Long add(News oneNew) {
        try {
            oneNew.setDateFrom(new Date());
//            oneNew.setAuthor(new PortalUser());
            em.persist(oneNew);
            System.out.printf("Successed added this News: " + oneNew);
        } catch (EntityExistsException e) {
            System.out.printf("Sorry, Opinion exist in DataBase! " + e.toString());
        } catch (Exception e) {
            System.err.printf("Sorry, can't add this News " + e.toString());
        }
        return oneNew.getId();
    }
    
    @Override    
    public Boolean edit(News oneNew) { 
        try { 
            News model = em.find(News.class, oneNew.getId()); 
            model.setDescription(oneNew.getDescription());
            model.setTitle(oneNew.getTitle());
            model.setUrlPhoto(oneNew.getUrlPhoto());
            model.setDateTo(oneNew.getDateTo());
            em.merge(model);
            return true; 
        } catch (Exception e) { 
            System.out.printf("Sorry, can't edit this News ", e); 
        }; 
        return false; 
    };
    
     @Override
    public News getById(Long id) {
        News model;
        try {
            model = em.find(News.class, id);
        } catch (Exception e) {
            model = new News();
            System.out.printf("Sorry, can't get News with id: " + id, e);
        }
        return model;
    }
    
    @Override
    public List<News> getAll() {
        try {
           CriteriaBuilder cb = em.getCriteriaBuilder();
           CriteriaQuery <News> cq = cb.createQuery(News.class);
           Root<News> root = cq.from(News.class);
           final List<News> result = em.createQuery(cq.select(root)).getResultList();
           System.out.printf("Znaleziono wyników: " + result.size());
           return result;
       } catch (Exception e) {
           System.out.printf("Sorry, can't get all News " + e);
       }
       return new ArrayList<News>();
    }   
    
    @Override
    public Boolean remove(Long id) {
        try {
            News model = em.find(News.class, id);
            em.remove(model);
            return true;
        } catch (Exception e) {
            System.out.printf("Sorry, can't remove this New ", e);
        }
        return false;
    }
}
