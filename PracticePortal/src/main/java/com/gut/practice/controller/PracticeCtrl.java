/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gut.practice.controller;

import com.gut.practice.entity.file.News;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author student
 */
@ManagedBean
@SessionScoped
public class PracticeCtrl {
    
    News info ;
    String test = "s";
    Integer count = 2;
    boolean immediately = true;
    boolean endless = false;
    
    private String firstname = "ssaa";
    private String lastname;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
 
    public String getFirstname() {
        return firstname;
    }
 
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
 
    public String getLastname() {
        return lastname;
    }
 
    public void setLastname(String lastname) {
        this.lastname = lastname;
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