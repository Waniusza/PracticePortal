/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gut.practice.service.user;

import com.gut.practice.entity.user.PortalUser;

/**
 *
 * @author kongo
 */
public class StudentService extends PortalUserService {
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
}
