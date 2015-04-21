/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gut.practice.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author janusz
 */
@Entity
@Table(name="ELEMENT")
public class Element implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String title;
    private Long value;
    private Boolean checked;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public void setChecked(Boolean check) {
        this.checked = check;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getTitle() {
        return title;
    }

    public Long getValue() {
        return value;
    }

    public Boolean getChecked() {
        return checked;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    @Override
    public String toString() {
        String result = title + " o id: " + id.toString();
        return result;
                
    }


}
