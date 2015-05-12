/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gut.practice.controller;

import java.io.Serializable;
import java.util.logging.Logger;
import javax.inject.Named;

/**
 *
 * @author janusz
 */
@Named
public class Testjsf implements Serializable {
    
    /**
     * Creates a new instance of testJSF
     */
    public String test = "JSF TEST";
    private static Logger log = Logger.getLogger(AddCtrl.class.getName());

  
    public Testjsf() {
        log.info("IM A NEW JSF CONTROLLLLLLER");
    }

    
    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }
    
    
    
}
