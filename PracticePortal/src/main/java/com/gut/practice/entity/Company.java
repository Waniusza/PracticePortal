/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gut.practice.entity;

import com.gut.practice.entity.user.Student;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import lombok.Getter;

/**
 *
 * @author janusz
 */
@Entity
@Getter

public class Company extends BaseModel {

    private String companyName;
//TODO complete Adress
    private String HRfirstName;
    private String HRlastName;
    private String HRemail;
    private String HRphone;
    private String adress;
    @ManyToOne
    private Student assignation;

    public Company() {
    }

    public Company setAdress(String adress) {
        this.adress = adress;
        return this;
    }

    public Company setAssignation(Student assignation) {
        this.assignation = assignation;
        return this;
    }

    public Company setCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public Company setHRemail(String HRemail) {
        this.HRemail = HRemail;
        return this;
    }

    public Company setHRfirstName(String HRfirstName) {
        this.HRfirstName = HRfirstName;
        return this;
    }

    public Company setHRlastName(String HRlastName) {
        this.HRlastName = HRlastName;
        return this;
    }

    public Company setHRphone(String HRphone) {
        this.HRphone = HRphone;
        return this;
    }
}
