/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gut.practice.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author janusz & kongo
 */
@MappedSuperclass
@Getter
@Setter 
@SequenceGenerator(name="seq",  initialValue=10000, allocationSize=100)
public abstract class BaseModel implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
    private Long id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreate;

    public BaseModel() {
    }

}
