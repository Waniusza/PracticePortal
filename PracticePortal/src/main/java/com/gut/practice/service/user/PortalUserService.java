package com.gut.practice.service.user;

import com.gut.practice.entity.user.PortalUser;
import com.gut.practice.service.BaseService;
import com.gut.practice.util.Permission;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
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
public class PortalUserService extends BaseService<PortalUser> {

    private static String INPUTFILE = "src/main/resources/jaas.config";

    @PersistenceContext
    protected EntityManager em;

    @Override
    public Long add(PortalUser portalUser) {
        if (validateUser(portalUser)) {
            System.out.println("Succes validation user");

            try {
                em.persist(portalUser);
                System.out.printf("Successfully added PortalUser id: " + portalUser.getId());
            } catch (EntityExistsException e) {
                System.out.printf("Sorry, PortalUser exists in DataBase! ", e);
            } catch (Exception e) {
                System.out.printf("Sorry, can't add this PortalUser ", e);
            }
        } else {
            System.out.println("Fail validation user");
        }
        return portalUser.getId();
    }

    @Override
    public Boolean edit(PortalUser portalUser) {
        PortalUser model = new PortalUser();
        try {
            model = em.find(PortalUser.class, portalUser.getId());
        } catch (Exception e) {
            System.out.printf("Sorry, can't edit this PortalUser ", e);
            return false;
        }
        model.setFirstName(portalUser.getFirstName());
        model.setLastName(portalUser.getLastName());
        model.setEmail(portalUser.getEmail());
        return true;

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
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<PortalUser> cq = cb.createQuery(PortalUser.class);
        Root<PortalUser> root = cq.from(PortalUser.class);

        try {
            return em.createQuery(cq.select(root)).getResultList();
        } catch (Exception e) {
            System.out.printf("Sorry, can't get all PortalUsers ", e);
        }
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

    public PortalUser sinIn(String name, String pass) {

        PortalUser user = checkIfExsist(name, pass);
        if (user != null) {
            if (!user.isLoged()) {
                user.setLoged(true);
                System.out.println("Success! You get to log in!");
            } else {
                System.out.println("Already loged");
            }
        } else {
            System.out.println("Sorry! Bad login or password.");
        }

        return user;
    }
  
    public PortalUser sinOut(PortalUser user) {
        user.setLoged(false);
        
        return null;
     }

    public boolean isPermissed(PortalUser user, Permission permission) {
        // Sprawdzenie czy użytkownik posiada dane uprawnienia
        for (Permission userPermission : user.getPermissions()) {
            if (userPermission.equals(permission)) {
                return true;
            }
        }
        return false;
    }

    public PortalUser checkIfExsist(String name, String password) {
        for (PortalUser portalUser : getAll()) {
            if (portalUser.getName().equals(name)) {
                if (portalUser.getPassword().equals(password)) {
                    return portalUser;
                }
            }
        }
        return null;
    }
      public boolean validateUser(PortalUser user){
         if(user.getName().length() == 0 || user.getPassword().length() == 0){
             return false;
         }
         
        if (checkIfExsist(user.getName(),  user.getPassword()) != null) {
            return false;
        }
        
        return true;
     }
}
