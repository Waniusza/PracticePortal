/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gut.practice.controller;

import com.gut.practice.entity.Faq;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;

/**
 *
 * @author janusz
 */
@Named
public class FaqList {
    private List<Faq> questions = new ArrayList<>();
    
    FaqList() {
        Faq question = new Faq();
        for (int i=1; i<5; i++) {
            question = new Faq();
            question.setQuestion("QUESTION " + i);
            question.setAnswer("ANSWER " + i);
            questions.add(question);
        }
    }

    public List<Faq> getQuestions() {
        return questions;
    }
    
    
}
