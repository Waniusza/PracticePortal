/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gut.practice.helpers.util;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

/**
 *
 * @author janusz
 */
public enum Permission {
    
    STUDENT, EMPLOYEER, COORDINATOR;
    
    public List<String> permissionsToSignIn(){
        List<String> result = new ArrayList<>();
        EnumSet<Permission> set = EnumSet.of(Permission.STUDENT, Permission.EMPLOYEER);
        set.forEach( (el) -> result.add(el.name()));
        return result;
    };
}
