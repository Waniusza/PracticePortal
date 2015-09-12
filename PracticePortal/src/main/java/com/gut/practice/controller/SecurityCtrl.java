/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gut.practice.controller;

import com.gut.practice.entity.user.PortalUser;
import com.gut.practice.service.user.PortalUserService;
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
    PortalUserService userService;
    
    String logName = "";
    String logPass = "";
    String newName = "";
    String newPass = "";
    String newPermission = "";
    PortalUser user = new PortalUser();
    List<String> availbleRoles = new ArrayList<>();
    
    public SecurityCtrl() {
        for( Permission perm : Permission.values()) {
            availbleRoles.add(perm.name());
        }
    }
    public void submitSignUp() {
        System.out.println("Rejestruje!" + newName + " :: " + newPass);
        PortalUser newUser = new PortalUser();
        List<Permission> perm = new ArrayList<>();
        perm.add(Permission.STUDENT);
        newUser.setName(newName)
                .setPassword(newPass)
                .setPermissions(perm);
        userService.add(newUser);
    }    
    public void submitSignIn() {
        System.out.println("Loguje!" + logName + " :: " + logPass);
        user = userService.sinIn(logName, logPass);
        logName = "";
        logPass = "";
    }
    
     public void submitSignOut() {
        System.out.println("Wylogowuje!" + logName + " :: " + logPass);
        userService.sinOut(user);
    }

    public PortalUser getUser() {
        return user;
    }

    public void setUser(PortalUser user) {
        this.user = user;
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

    public void setLogName(String logName) {
        this.logName = logName;
    }

    public String getLogName() {
        return logName;
    }

    public void setLogPass(String logPass) {
        this.logPass = logPass;
    }

    public String getLogPass() {
        return logPass;
    }
    
    public void setNewPass(String newPass) {
        this.newPass = newPass;
    }
    
    
    
    
    
}
