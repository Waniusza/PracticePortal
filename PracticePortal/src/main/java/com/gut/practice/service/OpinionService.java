package com.gut.practice.service;

import com.gut.practice.entity.Opinion;
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
public class OpinionService extends BaseService<Opinion> {
    @Override
    public Long add(Opinion opinion) {
        try {
            em.persist(opinion);
        } catch (EntityExistsException e) {
            System.out.printf("Sorry, Opinion exist in DataBase! ", e);
        } catch (Exception e) {
            System.out.printf("Sorry, can't add tihs Opinion ", e);
        }
        return opinion.getId();
    }
    
    @Override    
    public Boolean edit(Opinion opinion) { 
        try { 
            Opinion model = em.find(Opinion.class, opinion.getId()); 
            model.setCommentedEntityId(opinion.getCommentedEntityId());
            model.setComments(opinion.getComments()); 
            model.setText(opinion.getText()); 
            model.setAuthor(opinion.getAuthor());
            em.merge(opinion); 
            return true; } 
        catch (Exception e) { 
            System.out.printf("Sorry, can't edit this Opinion ", e); 
        }; 
        return false; 
    };
    
     @Override
    public Opinion getById(Long id) {
        Opinion model;
        try {
            model = em.find(Opinion.class, id);
        } catch (Exception e) {
            model = new Opinion();
            System.out.printf("Sorry, can't get Opinion with id: " + id, e);
        }
        
        return model;
    }
    
    @Override
    public List<Opinion> getAll() {
        try {
           CriteriaBuilder cb = em.getCriteriaBuilder();
           CriteriaQuery <Opinion> cq = cb.createQuery(Opinion.class);
           Root<Opinion> root = cq.from(Opinion.class);
           
           return em.createQuery(cq.select(root)).getResultList();
         
       } catch (Exception e) {
           
           System.out.printf("Sorry, can't get all Opinions " , e);
           
       }
       return new ArrayList<Opinion>();
    }   
    
    @Override
    public Boolean remove(Long id) {
        try {
            Opinion model = em.find(Opinion.class, id);
            em.remove(model);
            return true;
        } catch (Exception e) {
            System.out.printf("Sorry, can't remove this Subscription ", e);
        }
        return false;
    }
    
     public List<Opinion> getAllByDate(Date date) {
         List<Opinion> opinions = new ArrayList<Opinion>();
         for(Opinion opinion : getAll()){
             if(opinion.getDateCreate().equals(date))
                 opinions.add(opinion);
         }
         
         return opinions;
     }
}
