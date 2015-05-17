/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gut.practice.service;

import com.gut.practice.entity.Element;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author janusz
 */

@Stateless
@SessionScoped
public class AddService {

    @PersistenceContext
    private EntityManager em;
    
    private static Logger log = Logger.getLogger(AddService.class.getName());

    public AddService() {
        log.info("Hi, I'm new Service");
    }

    
    public void addElement (Element el) {
        
        log.info("Hi! I'm tring to add" + el.getTitle() + " o id: " + el.getId());
        em.merge(el);
        em.flush(); 
        log.info("Hi! I'm added" + el.getTitle() + " o id: " + el.getId());
        Query query = em.createQuery("SELECT n FROM Element n");
        List<Element> result = query.getResultList();
        
        log.info("Hi! I got" + result.size() + " elementes");
        for (Element ell : result) {
            log.info(ell.toString());
        }
    }
}
