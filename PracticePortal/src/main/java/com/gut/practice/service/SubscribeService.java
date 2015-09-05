/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gut.practice.service;

import com.gut.practice.entity.Subscribe;
import com.gut.practice.util.SubscribeType;
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
 * @author janusz & kongo
 */

@Stateless
@SessionScoped
public class SubscribeService extends BaseService<Subscribe> {
     @PersistenceContext
    protected EntityManager em;
    

    public SubscribeService() {
    }
    
    @Override
    public Long add(Subscribe sub) {
        try {
            em.persist(sub);
        } catch (EntityExistsException e) {
            System.out.printf("Sorry, Subscription exist in DataBase! ", e);
        } catch (Exception e) {
            System.out.printf("Sorry, can't add tihs Subscription ", e);
        }
        return sub.getId();
    }
    
    @Override    
    public Boolean edit(Subscribe sub) { 
        try { 
            Subscribe model = em.find(Subscribe.class, sub.getId()); 
            model.setTypes(sub.getTypes()); 
            model.setActive(sub.getActive()); 
            model.setEmail(sub.getEmail());  
            return true; } 
        catch (Exception e) { 
            System.out.printf("Sorry, can't edit this Subscription ", e); 
        }; 
        return false; 
    };
    
     @Override
    public Subscribe getById(Long id) {
        Subscribe model;
        try {
            model = em.find(Subscribe.class, id);
        } catch (Exception e) {
            model = new Subscribe();
            System.out.printf("Sorry, can't get Subscription with id: " + id, e);
        }
        
        return model;
    }
    
    @Override
    public List<Subscribe> getAll() {
        try {
           CriteriaBuilder cb = em.getCriteriaBuilder();
           CriteriaQuery <Subscribe> cq = cb.createQuery(Subscribe.class);
           Root<Subscribe> root = cq.from(Subscribe.class);
           
           return em.createQuery(cq.select(root)).getResultList();
         
       } catch (Exception e) {
           
           System.out.printf("Sorry, can't get all Subscriptions " , e);
           
       }
       return new ArrayList<Subscribe>();
    }   
    
    public Boolean remove(Long id) {
        try {
            Subscribe model = em.find(Subscribe.class, id);
            em.remove(model);
            return true;
        } catch (Exception e) {
            System.out.printf("Sorry, can't remove this Subscription ", e);
        }
        return false;
    }
    
     public List<Subscribe> getAllActive() {
        List<Subscribe> subscribes = new ArrayList<Subscribe>();
        for(Subscribe subscribe : getAll()){
            if(subscribe.getActive())
                subscribes.add(subscribe);
        }
        return subscribes;
     }
    
    public List<Subscribe> getAllByType(SubscribeType type) {
        List<Subscribe> subscribes = new ArrayList<Subscribe>();
        for(Subscribe subscribe : getAll()){
            for(SubscribeType type2 : subscribe.getTypes()){
                if(type.equals(type2)){
                    subscribes.add(subscribe);
                    break;
                }
            }
        }
        return subscribes;
    }
 }
