package com.gut.practice.helpers.util;

/**
 *
 * @author kongo
 */


public enum Speciality {
    PHYSIC(0), 
    MATHEMATIC(1), 
    IT(2);
    
    
    private int id;   
 
    private Speciality(int id) {
        this.id = id;
    }
 
    public static Speciality getType(Integer id) {
       
        if (id == null) {
            return null;
        }
 
        for (Speciality spec : Speciality.values()) {
            if (id.equals(spec.getId())) {
                return spec;
            }
        }
        throw new IllegalArgumentException("No matching speciality for id " + id);
    }
    
 
    public int getId() {
        return id;
    }
    
}
