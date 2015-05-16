/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gut.pactice.controller;

import java.io.Serializable;
import javax.inject.Named;

/**
 *
 * @author janusz
 */

@Named
public class TestCtrl implements Serializable{
    private String test = "sasa";

    
    public TestCtrl() {
        System.out.println("IM A NEW JSF CONTROLLLLLLER");
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }
    
    
}
