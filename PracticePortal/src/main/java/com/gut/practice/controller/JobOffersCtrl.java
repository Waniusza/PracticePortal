/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gut.practice.controller;

import com.gut.practice.entity.Company;
import com.gut.practice.entity.JobOffer;
import com.gut.practice.service.JobOfferService;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author janusz
 */
@ManagedBean
public class JobOffersCtrl {

    @EJB
    JobOfferService jobOfferService;

    List<JobOffer> offers = new ArrayList<>();
    JobOffer offer;
    Company company;

    public JobOffersCtrl() {

    }

    public List<JobOffer> getOffers() {
        setOffers(jobOfferService.getAll());
        return offers;
    }

    public void setOffers(List<JobOffer> offers) {
        
        this.offers = offers;
    }
    

}
