/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gut.practice.controller;

import com.gut.practice.service.FaqService;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;

/**
 *
 * @author janusz
 */
@ManagedBean
public class FaqListCtrl {
    private static final Logger log = LogManager.getLogger(FaqListCtrl.class);
    
    @EJB
    FaqService faqService;
    
    private JSONArray questions = new JSONArray();

    public FaqListCtrl() {
        log.debug("[FaqListCtrl] init");
    }

//    public JSONArray getQuestions() {
//        setQuestions(faqService.getAll());
//        return questions;
//    }
//  
//    public void setQuestions(JSONArray questions) {
//        this.questions = questions;
//    }

}
