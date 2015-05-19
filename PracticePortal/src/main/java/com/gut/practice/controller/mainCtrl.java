/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gut.practice.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;

/**
 *
 * @author janusz
 */

@Named

public class mainCtrl implements Serializable{
    
    private List<String> availbleRoles = new ArrayList<>();
    private String selectedRole = null;

    public mainCtrl() {
        availbleRoles.add("STUDENT");
        availbleRoles.add("COORDINATOR");
        availbleRoles.add("EMPLOYER");
        selectedRole = availbleRoles.get(0);
    }
    
    
    
    
}
