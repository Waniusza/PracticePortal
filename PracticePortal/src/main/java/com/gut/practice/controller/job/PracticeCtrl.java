/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gut.practice.controller.job;

import com.gut.practice.entity.Practice;
import com.gut.practice.service.PracticeService;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author student
 */
@ManagedBean
@SessionScoped
public class PracticeCtrl implements Serializable{
    private static final Logger log = LogManager.getLogger(PracticeCtrl.class);
  
    // TODO :Implement view - 
    @EJB
    PracticeService practiceService;
    Practice addPractice = new Practice();
    
    
    boolean immediately = true;
    boolean endless = false;

    public void submit(){
        log.debug("SUBMITUJE");
    }
    public Practice getAddPractice() {
        return addPractice;
    }

    public void setAddPractice(Practice addPractice) {
        this.addPractice = addPractice;
    }
 
    
    public boolean getImmediately() {
        return immediately;
    }
    public void setImmediately(boolean b) {
        this.immediately = b;
    }

    
}