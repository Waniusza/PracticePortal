/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gut.practice.controller;

import com.gut.practice.entity.Practice;
import com.gut.practice.service.PracticeService;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author student
 */
@ManagedBean
@SessionScoped
public class PracticeCtrl {
  
    // TODO :Implement view - 
    @EJB
    PracticeService practiceService;
    Practice addPractice = new Practice();
    
    
    boolean immediately = true;
    boolean endless = false;
 
    
    public boolean getImmediately() {
        return immediately;
    }
    public void setImmediately(boolean b) {
        this.immediately = b;
    }

    
}