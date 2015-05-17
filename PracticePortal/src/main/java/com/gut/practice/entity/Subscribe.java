/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gut.practice.entity;

import com.gut.practice.entity.enums.SubscribeType;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author janusz
 */
@Entity
@Getter
@Setter
@ToString
public class Subscribe extends BaseModel{
    
    private String email;
    private Boolean active = true;
    
    @OneToMany
    private List<SubscribeType> types;
    
    
    public Subscribe() {
    }
    
    
}
