package com.gut.practice.service;

import com.gut.practice.entity.Practice;
import com.gut.practice.entity.enums.ConfirmationStatus;
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
public class PracticeService extends BaseService<Practice>  {

    @Override
    public Long add(Practice practice) {
         try {
            em.persist(practice);
        } catch (EntityExistsException e) {
            System.out.printf("Sorry, Practice exist in DataBase! ", e);
        } catch (Exception e) {
            System.out.printf("Sorry, can't add tihs Practice ", e);
        }
        return practice.getId();
    }
    
    @Override
    public Boolean edit(Practice practice) {
       try { 
            Practice model = em.find(Practice.class, practice.getId()); 
            model.setDateFrom(practice.getDateFrom()); 
            model.setDateTo(practice.getDateTo()); 
            model.setHours(practice.getHours()); 
            model.setEmployer(practice.getEmployer()); 
            model.setConfirmationStatus(practice.getConfirmationStatus()); 
            return true; } 
        catch (Exception e) { 
            System.out.printf("Sorry, can't edit this Practice ", e); 
        }; 
        return false; 
    }

    @Override
    public Practice getById(Long id) {
      Practice model;
        try {
            model = em.find(Practice.class, id);
        } catch (Exception e) {
            model = new Practice();
            System.out.printf("Sorry, can't get Practice with id: " + id, e);
        }
        
        return model;
    }

    @Override
    public List<Practice> getAll() {
        try {
           CriteriaBuilder cb = em.getCriteriaBuilder();
           CriteriaQuery <Practice> cq = cb.createQuery(Practice.class);
           Root<Practice> root = cq.from(Practice.class);
           
           return em.createQuery(cq.select(root)).getResultList();
         
       } catch (Exception e) {
           
           System.out.printf("Sorry, can't get all Practices " , e);
           
       };
       return new ArrayList<Practice>();
    }
    
    @Override
    public Boolean remove(Long id) {
        try {
            Practice model = em.find(Practice.class, id);
            em.remove(model);
            return true;
        } catch (Exception e) {
            System.out.printf("Sorry, can't remove this Practice ", e);
        }
        return false;
    }
    
    public List<Practice> getAllByDate(Date dateFrom, Date dateTo) {
         List<Practice> pratices = new ArrayList<Practice>();
         for(Practice practice : getAll()){
             if(!practice.getDateFrom().before(dateFrom) || !practice.getDateTo().after(dateTo))
                 pratices.add(practice);
         }
         
         return pratices;
    }
    
    public void confirm(Long id, ConfirmationStatus confirmationStatus){
        Practice model;
        try {
            model = em.find(Practice.class, id);
            model.setConfirmationStatus(confirmationStatus);
        } catch (Exception e) {
            System.out.printf("Sorry, can't get Practice with id: " + id + " and confirm status ", e);
        }
    }
}
