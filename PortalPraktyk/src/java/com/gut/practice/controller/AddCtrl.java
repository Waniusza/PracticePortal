/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gut.practice.controller;

import com.gut.practice.entity.Element;
import com.gut.practice.service.AddService;
import java.io.Serializable;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author janusz
 */
@ManagedBean 
public class AddCtrl implements Serializable {


    @EJB
    private AddService addServ;
    private Element element = null;
    private String test = "Moj test";

    private static Logger log = Logger.getLogger(AddCtrl.class.getName());

    public AddCtrl() {
        log.info("IM A NEW ADDCTRLO");
    }

    public static Logger getLog() {
        return log;
    }

    public static void setLog(Logger log) {
        AddCtrl.log = log;
    }

    public Element getElement() {
        if (element == null) {
            element = new Element();
        }
        return element;

    }

    public void setElement(Element element) {
        this.element = element;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public void add() {
        log.info("MAM CIE!!");
        log.info(element.getTitle());
        log.info(element.getChecked().toString());
        log.info(element.getValue().toString());
        addServ.addElement(element);
        element = null;
    }


}
