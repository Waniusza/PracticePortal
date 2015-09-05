package com.gut.practice.service.user;

import com.gut.practice.entity.TimePeriod;
import com.gut.practice.entity.user.Coordinator;
import java.util.List;
import javax.ejb.Stateless;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author kongo
 */

@Stateless
@SessionScoped
public class CoordinatorService extends PortalUserService {
    public boolean whenAvailablity(List<TimePeriod> availablity){
        try { 
            Coordinator coordinator = new Coordinator();//FIXME
            coordinator.getAvailablity().clear();
            coordinator.setAvailablity(availablity);
            return true; } 
        catch (Exception e) { 
            System.out.printf("Sorry, can't set availablity ", e); 
        }; 
        return false; 
    }
}
