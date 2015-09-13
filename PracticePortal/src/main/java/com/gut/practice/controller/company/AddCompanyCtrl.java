/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gut.practice.controller.company;

import com.gut.practice.entity.Company;
import com.gut.practice.service.CompanyService;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author janusz
 */
@ManagedBean
public class AddCompanyCtrl {
    
    @EJB
    private CompanyService companyService;
    
    private String companyName;
    private String HRfirstName;
    private String HRlastName;
    private String HRemail;
    private String HRphone;
    
    public AddCompanyCtrl() {
        System.out.println("[AddCompanyCtrl] init");
    }
     
    public void submit()  {
        Company newCompany = new Company()
                .setCompanyName(companyName)
                .setHRemail(HRemail)
                .setHRfirstName(HRfirstName)
                .setHRlastName(HRlastName)
                .setHRphone(HRphone);
        
        System.out.println("SUBMITUJE : " + companyName + "!");
        companyService.add(newCompany);
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getHRemail() {
        return HRemail;
    }

    public void setHRemail(String HRemail) {
        this.HRemail = HRemail;
    }

    public String getHRfirstName() {
        return HRfirstName;
    }

    public void setHRfirstName(String HRfirstName) {
        this.HRfirstName = HRfirstName;
    }

    public String getHRlastName() {
        return HRlastName;
    }

    public void setHRlastName(String HRlastName) {
        this.HRlastName = HRlastName;
    }

    public String getHRphone() {
        return HRphone;
    }

    public void setHRphone(String HRphone) {
        this.HRphone = HRphone;
    }

    
    
}
