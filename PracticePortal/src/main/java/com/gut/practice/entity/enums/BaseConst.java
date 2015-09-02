/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gut.practice.entity.enums;

import com.gut.practice.entity.BaseModel;
import javax.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author janusz
 */

@MappedSuperclass
@Getter
@Setter

public abstract class BaseConst extends BaseModel{
   
    private String paramName;
    private Boolean active;
    
}
