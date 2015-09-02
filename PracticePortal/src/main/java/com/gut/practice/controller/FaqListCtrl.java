/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gut.practice.controller;

import com.gut.practice.entity.Faq;
import com.gut.practice.service.FaqService;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author janusz
 */
@ManagedBean
public class FaqListCtrl {

    @EJB
    FaqService faqService;
    
    private List<Faq> questions = new ArrayList<>();

    public FaqListCtrl() {
        System.out.println("[FaqListCtrl] init");
    }

    public List<Faq> getQuestions() {
        setQuestions(faqService.getAll());
        return questions;
    }

    public void setQuestions(List<Faq> questions) {
        this.questions = questions;
    }

}
