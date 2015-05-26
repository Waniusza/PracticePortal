/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gut.practice.controller;

import com.gut.practice.helpers.ViewTab;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.event.TabChangeEvent;
import org.primefaces.event.TabCloseEvent;

/**
 *
 * @author janusz
 */
@Named
public class NewsCtrl {
    
    private List<ViewTab> optionsList = new ArrayList<>();
    private Date dateFrom = new Date();
    private Date dateTo = new Date();
    
    public NewsCtrl() {
        optionsList.add(new ViewTab("Add new", "res1"));
        optionsList.add(new ViewTab("Show list", "../templates/newsList.xhtml"));
    }
     
    public void onTabChange(TabChangeEvent event) {
        FacesMessage msg = new FacesMessage("Tab Changed", "Active Tab: " + event.getTab().getTitle() + "All options: " );
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
         
    public void onTabClose(TabCloseEvent event) {
        FacesMessage msg = new FacesMessage("Tab Closed", "Closed tab: " + event.getTab().getTitle());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }


    public List<ViewTab> getOptionsList() {
        return optionsList;
    }
    
    
    
}
