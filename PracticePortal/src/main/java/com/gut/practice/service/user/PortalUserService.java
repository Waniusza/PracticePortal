package com.gut.practice.service.user;

import com.gut.practice.entity.user.PortalUser;
import com.gut.practice.service.BaseService;
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
        try {
            em.persist(portalUser);
        } catch (EntityExistsException e) {
            System.out.printf("Sorry, PortalUser exist in DataBase! ", e);
        } catch (Exception e) {
            System.out.printf("Sorry, can't add this PortalUser ", e);
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
            return true;
        } catch (Exception e) {
            System.out.printf("Sorry, can't edit this PortalUser ", e);
        }
        return false;
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
            CriteriaQuery<PortalUser> cq = cb.createQuery(PortalUser.class);
            Root<PortalUser> root = cq.from(PortalUser.class);

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
    /*
     public PortalUser sinIn(String name, String pass) {
     System.setProperty("java.security.auth.login.config", INPUTFILE);
        
     PortalUser user = null;
     try {
     user = checkIfExsist(name, pass);
     LoginContext loginContext = new LoginContext("Test", new MyCallbackHandler(user));
     loginContext.login();
     user.setLoginContext(loginContext);
            
     } catch (LoginException e) {
     e.printStackTrace();
     return null;
     }
        
     return user;
     }
    
     public User sinOut(String name, String pass) {
     PortalUser user = null;
     try {
     user = checkIfExsist(name, pass);
     user.getLoginContext().logout();
     } catch (LoginException e) {
     e.printStackTrace();
     }
     return new User();
     }
    
     public boolean isPermissed(PortalUser user, Permission permission) {
     // Sprawdzenie czy użytkownik posiada dane uprawnienia
     for(Permission userPermission : user.getPermissions())
     if(userPermission.equals(permission))
     return true;
     return false;
     }

     public PortalUser checkIfExsist(String name, String password){
     for(PortalUser portalUser : getAll()){
     if(portalUser.getName().equals(name))
     if(portalUser.getPassword().equals(password))
     return portalUser;
     }
     return null;
     }
     */
}
