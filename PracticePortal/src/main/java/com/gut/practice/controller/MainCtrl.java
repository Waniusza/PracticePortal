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

public class MainCtrl implements Serializable{
    
    private final List<String> availbleRoles = new ArrayList<>();
    private String selectedRole;
    
    private final List<String> availableOpinions = new ArrayList<>();
    private  String selectedOpinion;

    public MainCtrl() {
        this.selectedRole = null;
        availbleRoles.add("STUDENT");
        availbleRoles.add("COORDINATOR");
        availbleRoles.add("EMPLOYER");
        selectedRole = availbleRoles.get(0);
        availableOpinions.add("1_POOR");
        availableOpinions.add("2_WEEK");
        availableOpinions.add("3_OK");
        availableOpinions.add("4_NICE");
        availableOpinions.add("5_GREAT");
    }

    public List<String> getAvailableOpinions() {
        return availableOpinions;
    }
    
    
    
    
    
}
