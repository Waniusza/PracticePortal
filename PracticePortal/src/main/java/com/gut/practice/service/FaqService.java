package com.gut.practice.service;

import com.gut.practice.entity.Faq;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author kongo
 */

@Stateless
@SessionScoped
public class FaqService extends BaseService<Faq> {
    
    @PersistenceContext
    public static EntityManager em;
    
    @Override
    public Long add(Faq oneFAQ) {
        try {
            em.persist(oneFAQ);
            System.out.printf("Successed added this FAQ: " + oneFAQ);
        } catch (EntityExistsException e) {
            System.out.printf("Sorry, FAQ exist in DataBase! " + e.toString());
        } catch (Exception e) {
            System.err.printf("Sorry, can't add this FAQ " + e.toString());
        }
        return oneFAQ.getId();
    }
    
    @Override    
    public Boolean edit(Faq oneFAQ) { 
        try { 
            Faq model = em.find(Faq.class, oneFAQ.getId()); 
            model.setQuestion(oneFAQ.getQuestion());
            model.setAnswer(oneFAQ.getAnswer());
            em.merge(model);
            return true; 
        } catch (Exception e) { 
            System.out.printf("Sorry, can't edit this FAQ ", e); 
        }; 
        return false; 
    };
    
     @Override
    public Faq getById(Long id) {
        Faq model;
        try {
            model = em.find(Faq.class, id);
        } catch (Exception e) {
            model = new Faq();
            System.out.printf("Sorry, can't get FAQ with id: " + id, e);
        }
        return model;
    }
    
    @Override
    public List<Faq> getAll() {
        try {
           CriteriaBuilder cb = em.getCriteriaBuilder();
           CriteriaQuery <Faq> cq = cb.createQuery(Faq.class);
           Root<Faq> root = cq.from(Faq.class);
           final List<Faq> result = em.createQuery(cq.select(root)).getResultList();
           System.out.printf("Znaleziono wyników: " + result.size());
           return result;
       } catch (Exception e) {
           System.out.printf("Sorry, can't get all Faq " + e);
       }
       return new ArrayList<Faq>();
    }   
    
    @Override
    public Boolean remove(Long id) {
        try {
            Faq model = em.find(Faq.class, id);
            em.remove(model);
            return true;
        } catch (Exception e) {
            System.out.printf("Sorry, can't remove this New ", e);
        }
        return false;
    }
}
