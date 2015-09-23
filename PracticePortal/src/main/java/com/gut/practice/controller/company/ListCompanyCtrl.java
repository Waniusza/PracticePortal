/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gut.practice.controller.company;

import com.gut.practice.entity.Company;
import com.gut.practice.service.CompanyService;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author janusz
 */
@ManagedBean
public class ListCompanyCtrl {
    private static final Logger log = LogManager.getLogger(ListCompanyCtrl.class);

    @EJB
    private CompanyService companyService;

    private List<Company> companies;

    public ListCompanyCtrl() {
        log.debug("[ListCompanyCtrl] init");
    }

    @PostConstruct
    private void init() {
        _getData();

    }

    private void _getData() {
        log.debug("[ListCompanyCtrl] _getData");
        companies = companyService.getAll();
    }

    public List<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }

}
