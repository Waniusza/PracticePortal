/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gut.practice.entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
public class JobOffer extends BaseModel{


    @ManyToOne
    private Company company;
    private String mainDuty;
    private Integer salaryMin;
    private Integer salaryMax;
    @Temporal(TemporalType.DATE)
    private Date dateTo;
    
    public JobOffer() {
        
    }
    
    
    
}
