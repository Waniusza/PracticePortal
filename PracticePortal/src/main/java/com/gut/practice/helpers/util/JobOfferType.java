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
public enum JobOfferType {

    PRAKTICE(1), JOB(2), INTERNSHIP(3), TRAINING(4);

    
    private int id;
    
    private JobOfferType(int id) {
        this.id = id;
    }
 
    public static JobOfferType getType(Integer id) {
       
        if (id == null) {
            return null;
        }
 
        for (JobOfferType type : JobOfferType.values()) {
            if (id.equals(type.getId())) {
                return type;
            }
        }
        throw new IllegalArgumentException("No matching type for id " + id);
    }
    
 
    public int getId() {
        return id;
    }
}
