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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author janusz
 */
@ManagedBean
public class AddCompanyCtrl {
    private static final Logger log = LogManager.getLogger(AddCompanyCtrl.class);
    
    @EJB
    private CompanyService companyService;
    
    private String companyName;
    private String HRfirstName;
    private String HRlastName;
    private String HRemail;
    private String HRphone;
    
    private String city;
    private String postcode;
    private String street;
    private int homeNumber;
    private int apartmentNumber;
    
    public AddCompanyCtrl() {
        log.debug("[AddCompanyCtrl] init");
    }
     
    public void submit()  {
        Company newCompany = new Company()
                .setCompanyName(companyName)
                .setHRemail(HRemail)
                .setHRfirstName(HRfirstName)
                .setHRlastName(HRlastName)
                .setHRphone(HRphone)
                .setApartmentNumber(apartmentNumber)
                .setCity(city)
                .setHomeNumber(homeNumber)
                .setPostcode(postcode)
                .setStreet(street);
        
        log.debug("SUBMITUJE : " + companyName + "!");
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

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreet() {
        return street;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setHomeNumber(int homeNumber) {
        this.homeNumber = homeNumber;
    }

    public int getHomeNumber() {
        return homeNumber;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setApartmentNumber(int apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }

    
    
}
