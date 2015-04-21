/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gut.practice.controller;

import java.io.Serializable;
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
    
    
    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }
    
    
    
}
