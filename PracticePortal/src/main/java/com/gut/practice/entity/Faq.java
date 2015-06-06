/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gut.practice.entity;

import javax.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author janusz
 */

@Entity
@Getter
@Setter
@ToString
public class Faq extends BaseModel{
    private String question;
    private String answer;
    
    public Faq() {
    }
    
}