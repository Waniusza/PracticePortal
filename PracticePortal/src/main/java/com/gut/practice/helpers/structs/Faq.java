/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gut.practice.helpers.structs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 *
 * @author janusz
 */

@Getter
@ToString
@AllArgsConstructor
public class Faq {
    private String question;
    private String answer;
    
    public Faq() {
    }

    public Faq setAnswer(String answer) {
        this.answer = answer;
        return this;
    }

    public Faq setQuestion(String question) {
        this.question = question;
        return this;
    }
    
    
}