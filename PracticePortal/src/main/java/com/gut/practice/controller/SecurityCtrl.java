/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gut.practice.controller;

import com.gut.practice.service.SecurityService;
import com.gut.practice.service.login.User;
import com.gut.practice.util.Permission;
import java.util.ArrayList;
import java.util.List;
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
    String newPermission = "";
    List<String> availbleRoles = new ArrayList<>();
    User newUser = new User();
    
    public SecurityCtrl() {
        for( Permission perm : Permission.values()) {
            availbleRoles.add(perm.name());
        }
    }
    public void submitSignUp() {
        System.out.println("Rejestruje!" + newUser.getName() + " :: " + newUser.getPassword());
    }

    public User getNewUser() {
        return newUser;
    }
    public void setNewUser(User newUser) {
        this.newUser = newUser;
    }

    public String getNewName() {
        return newName;
    }
    public void setNewName(String newName) {
        this.newName = newName;
    }

    public List<String> getAvailbleRoles() {
        return availbleRoles;
    }

    public void setAvailbleRoles(List<String> availbleRoles) {
        this.availbleRoles = availbleRoles;
    }

    public String getNewPermission() {
        return newPermission;
    }

    public void setNewPermission(String newPermission) {
        this.newPermission = newPermission;
    }

    
    
    public String getNewPass() {
        return newPass;
    }

    public void setNewPass(String newPass) {
        this.newPass = newPass;
    }
    
    
    
    
    
}
