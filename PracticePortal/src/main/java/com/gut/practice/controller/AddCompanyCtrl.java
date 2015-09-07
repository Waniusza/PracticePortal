/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gut.practice.controller;

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
    private Company newCompany = new Company();
    
    public AddCompanyCtrl() {
        System.out.println("[AddCompanyCtrl] init");
    }
     
    
   
    public void submit()  {
        System.out.println("SUBMITUJE : " + newCompany.toString() + "!");
//        newsService.add(addNew);
        newCompany = new Company();
    }

    public void setNewCompany(Company newCompany) {
        this.newCompany = newCompany;
    }

    public Company getNewCompany() {
        return newCompany;
    }
}
