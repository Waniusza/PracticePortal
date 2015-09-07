/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gut.practice.controller;

import com.gut.practice.entity.user.PortalUser;
import com.gut.practice.service.SecurityService;
import com.gut.practice.service.login.User;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author janusz
 */
@ManagedBean
public class SecurityCtrl {
    
    @EJB
    SecurityService securityService;
    
    String newName = "";
    String newPass = "";
    PortalUser newUser = new PortalUser();
    
    public void submitSignUp() {
        System.out.println("Rejestruje!" + newUser.getName() + " :: " + newUser.getPassword());
    }

    public PortalUser getNewUser() {
        return newUser;
    }

    public void setNewUser(PortalUser newUser) {
        this.newUser = newUser;
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    public String getNewPass() {
        return newPass;
    }

    public void setNewPass(String newPass) {
        this.newPass = newPass;
    }
    
    
    
    
    
}
