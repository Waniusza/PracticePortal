/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gut.practice.controller;

import com.gut.practice.entity.Company;
import com.gut.practice.entity.JobOffer;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Named;

/**
 *
 * @author janusz
 */
@Named
public class JobOffersCtrl {

    List<JobOffer> offers = new ArrayList<>();
    JobOffer offer;
    Company company;
    
    public JobOffersCtrl() {
    
        for (int i=1; i<7; i++) {
            offer = new JobOffer();
            company = new Company();
            company.setCompanyName("Company" + i);
            offer.setCompany(company);
            offer.setMainDuty("Duty" + i);
            offer.setSalaryMax(1000 * i + 500);
            offer.setSalaryMin(500 * i + 1000);
            offer.setDateTo(new Date());
            offers.add(offer);
            System.out.print(offer);
        }
        
    }

    public List<JobOffer> getOffers() {
        return offers;
    }
    
    
    
    
    
}
