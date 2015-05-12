/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gut.practice.controller;

import com.gut.practice.entity.Element;
import java.io.Serializable;
import java.util.logging.Logger;
import javax.inject.Named;

/**
 *
 * @author janusz
 */
@Named
public class AddCtrl implements Serializable {

//
//    @Inject
//    private AddService addServ;
    private Element element = new Element();
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
        log.info("MAM CIE!!");
        
 //       addServ.addElement(element);
        element = null;
    }


}
