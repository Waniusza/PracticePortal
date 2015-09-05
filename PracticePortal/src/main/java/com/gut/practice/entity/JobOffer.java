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
import lombok.ToString;

/**
 *
 * @author janusz
 */

@Entity
@Getter
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

    public JobOffer setCompany(Company company) {
        this.company = company;
        return this;
    }

    public JobOffer setDateTo(Date dateTo) {
        this.dateTo = dateTo;
        return this;
    }

    public JobOffer setMainDuty(String mainDuty) {
        this.mainDuty = mainDuty;
        return this;
    }

    public JobOffer setSalaryMax(Integer salaryMax) {
        this.salaryMax = salaryMax;
        return this;
    }

    public JobOffer setSalaryMin(Integer salaryMin) {
        this.salaryMin = salaryMin;
        return this;
    }
    
    
    
}
