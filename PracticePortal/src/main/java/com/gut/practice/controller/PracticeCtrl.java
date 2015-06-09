/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gut.practice.controller;

import com.gut.practice.entity.file.News;
import javax.inject.Named;

/**
 *
 * @author student
 */
@Named
public class PracticeCtrl {
    
    News info ;
    String test = "s";
    boolean immediately = true;
    boolean endless = false;
    
    PracticeCtrl() {
        info = new News();
    }

    public News getInfo() {
        return info;
    }
    public void setInfo( News i) {
        info = i;
    }
    public boolean getImmediately() {
        return immediately;
    }
    public void setImmediately(boolean b) {
        this.immediately = b;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }
    
    
}