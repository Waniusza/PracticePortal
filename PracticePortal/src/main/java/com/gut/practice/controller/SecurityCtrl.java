/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gut.practice.controller;

import com.gut.practice.service.SecurityService;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.security.auth.login.LoginContext;

/**
 *
 * @author janusz
 */
@ManagedBean
public class SecurityCtrl {
    
    @EJB
    SecurityService securityService;
    
    LoginContext ctx;
    String newName = "";
    String newPass = "";
    String logName = "";
    String logPass = "";
    
    public void submitSignUp() {
        System.out.println("Rejestruje!" + newName + " :: " + newPass);
    }    
    public void submitSignIn() {
        System.out.println("Loguje!" + logName + " :: " + logPass);
        logName = "";
        logPass = "";
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
