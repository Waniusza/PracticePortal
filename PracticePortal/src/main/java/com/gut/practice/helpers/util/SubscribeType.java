package com.gut.practice.helpers.util;

/**
 *
 * @author janusz
 */

public enum SubscribeType{
    ALL(0), 
    ONLY_JOB_OFFERS(1), 
    ONLY_NEWS(2);
    
    private int id;   
 
    private SubscribeType(int id) {
        this.id = id;
    }
 
    public static SubscribeType getType(Integer id) {
       
        if (id == null) {
            return null;
        }
 
        for (SubscribeType type : SubscribeType.values()) {
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
