/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gut.practice.helpers.util;

/**
 *
 * @author janusz
 */
public enum OpinionName {
     POOR(0), 
     WEEK(1), 
     OK(2), 
     NICE(3), 
     GREAT(4);
     
    private final int id;  
      
      
    private OpinionName(int id) {
        this.id = id;
    }
    
      public static OpinionName getOpinion(Integer id) {
       
        if (id == null) {
            return null;
        }
 
        for (OpinionName opinion : OpinionName.values()) {
            if (id.equals(opinion.getId())) {
                return opinion;
            }
        }
        throw new IllegalArgumentException("No matching opinion for id " + id);
    }
    
 
    public int getId() {
        return id;
    }
 
}
