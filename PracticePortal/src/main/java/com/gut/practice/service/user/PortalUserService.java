package com.gut.practice.service.user;

import com.gut.practice.entity.user.PortalUser;
import com.gut.practice.entity.user.Student;
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
    public Boolean edit(PortalUser portalUser) { 
        try { 
            PortalUser model = em.find(PortalUser.class, portalUser.getId()); 
            model.setFirstName(portalUser.getFirstName());
            model.setLastName(portalUser.getLastName()); 
            model.setEmail(portalUser.getEmail()); 
            return true; } 
        catch (Exception e) { 
            System.out.printf("Sorry, can't edit this PortalUser ", e); 
        }; 
        return false; 
    };

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
        try {
            PortalUser model = em.find(PortalUser.class, id);
            em.remove(model);
            return true;
        } catch (Exception e) {
            System.out.printf("Sorry, can't remove this PortalUser ", e);
        }
        return false;
    }

    public boolean checkIfExsist(PortalUser portalUser){
        for(PortalUser portalUser2 : getAll()){
            if(portalUser.getEmail().equals(portalUser2.getEmail()))
                return true;
            if(portalUser instanceof Student && portalUser2 instanceof Student){
                Student student = (Student) portalUser;
                Student student2 = (Student) portalUser2;
                if(student.getIndexID() == student2.getIndexID())
                    return true;
            }
        }

        return false;
    }
    
    //TODO edit student, employer, coordinator
}
