/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gut.practice.controller;

import com.gut.practice.entity.Company;
import com.gut.practice.service.CompanyService;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author janusz
 */
@ManagedBean
public class ListCompanyCtrl {
    
    @EJB
    private CompanyService companyService;
    
    private List<Company> companies;
    
    public ListCompanyCtrl() {
        System.out.println("[ListCompanyCtrl] init");
        _getData();
    }
    
    private void _getData() {
        companies = companyService.getAll();
    }

    public List<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }
   

}
