/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gut.practice.entity;

import com.gut.practice.util.SubscribeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import lombok.Getter;
import lombok.ToString;

/**
 *
 * @author janusz
 */

@Entity
@Getter
@ToString

public class Subscribe extends BaseModel{
    
    private String email;
    private Boolean active = true;
     
    @Enumerated(EnumType.STRING)
    private SubscribeType[] types;

    public Subscribe setActive(Boolean active) {
        this.active = active;
        return this;
    }

    public Subscribe setEmail(String email) {
        this.email = email;
        return this;
    }

    public Subscribe setTypes(SubscribeType[] types) {
        this.types = types;
        return this;
    }
    
    
    public Subscribe() {
    }
    
    
}
