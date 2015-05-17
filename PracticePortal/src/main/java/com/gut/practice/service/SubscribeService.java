/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gut.practice.service;

import com.gut.practice.entity.Subscribe;
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
 * @author janusz
 */

@Stateless
@SessionScoped
public class SubscribeService {
    
    @PersistenceContext
    private EntityManager em;

    public SubscribeService() {
    }
    
    public Long addSubscribe(Subscribe sub) {
        try {
            em.persist(sub);
        } catch (EntityExistsException e) {
            System.out.printf("Sorry, Subscription exist in DataBase! ", e);
        } catch (Exception e) {
            System.out.printf("Sorry, can't add tihs Subscription ", e);
        }
        return sub.getId();
    };
    
    public Boolean removeSubscibe (Subscribe sub) {
      try {
          Subscribe model = em.find(Subscribe.class, sub.getId());
          model.setTypes(sub.getTypes());
          model.setActive(sub.getActive());
          model.setEmail(sub.getEmail());
          
          em.merge(sub);
          return true;
      }  catch (Exception e) {
            System.out.printf("Sorry, can't remove this Subscription ", e);
      };
      
      return false;
    };
    
    public Subscribe getSubscribeById (Long id) {
        Subscribe model;
        try {
            model = em.find(Subscribe.class, id);
        } catch (Exception e) {
            model = new Subscribe();
            System.out.printf("Sorry, can't get Subscription with id: " + id, e);
        }
        
        return model;
    };
    
    public List<Subscribe> getAllSubscribe  () {
      
       try {
           CriteriaBuilder cb = em.getCriteriaBuilder();
           CriteriaQuery <Subscribe> cq = cb.createQuery(Subscribe.class);
           Root<Subscribe> root = cq.from(Subscribe.class);
           
           return em.createQuery(cq.select(root)).getResultList();
         
       } catch (Exception e) {
           
           System.out.printf("Sorry, can't get all Subscriptions " , e);
           
       };
       return new ArrayList<Subscribe>();
    };
    
    
    
    
    
}
