package com.gut.practice.service.user;

import com.gut.practice.entity.user.PortalUser;
import com.gut.practice.service.BaseService;
import java.util.ArrayList;
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
public class PortalUserService extends BaseService<PortalUser>  {

    @Override
    public Long add(PortalUser portalUser) {
         try {
            em.persist(portalUser);
        } catch (EntityExistsException e) {
            System.out.printf("Sorry, PortalUser exist in DataBase! ", e);
        } catch (Exception e) {
            System.out.printf("Sorry, can't add tihs PortalUser ", e);
        }
        return portalUser.getId();
    }
    
    @Override
    public Boolean edit(PortalUser d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PortalUser getById(Long id) {
      PortalUser model;
        try {
            model = em.find(PortalUser.class, id);
        } catch (Exception e) {
            model = new PortalUser();
            System.out.printf("Sorry, can't get PortalUser with id: " + id, e);
        }
        
        return model;
    }

    @Override
    public List<PortalUser> getAll() {
        try {
           CriteriaBuilder cb = em.getCriteriaBuilder();
           CriteriaQuery <PortalUser> cq = cb.createQuery(PortalUser.class);
           Root<PortalUser> root = cq.from(PortalUser.class);
           
           return em.createQuery(cq.select(root)).getResultList();
         
       } catch (Exception e) {
           
           System.out.printf("Sorry, can't get all PortalUsers " , e);
           
       };
       return new ArrayList<PortalUser>();
    }
    
     @Override
    public Boolean remove(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean checkIfExsist(PortalUser portalUser){
        for(PortalUser portalUser2 : getAll())
            if(portalUser.getFirstName().equals(portalUser2.getFirstName()) && portalUser.getLastName().equals(portalUser2.getLastName()))
                return true;

        return false;
    }
    
    public boolean checkIfExsist(String firstName, String lastName){
        for(PortalUser portalUser2 : getAll())
            if(firstName.equals(portalUser2.getFirstName()) && lastName.equals(portalUser2.getLastName()))
                return true;

        return false;
    }
    
    //TODO zmienic edit i remove
    //TODO confirm(long):bool
}
