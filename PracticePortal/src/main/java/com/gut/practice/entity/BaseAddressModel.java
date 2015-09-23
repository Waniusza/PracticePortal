/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gut.practice.entity;

import javax.persistence.MappedSuperclass;
import lombok.Getter;

/**
 *
 * @author janusz
 */

@MappedSuperclass
@Getter


public abstract class BaseAddressModel extends BaseModel{
 
    protected String city;
    protected String postcode;
    protected String street;
    protected int homeNumber;
    protected int apartmentNumber;

    public BaseAddressModel() {
    }
}
