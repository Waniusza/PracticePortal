/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gut.practice.controller;

import com.gut.practice.entity.file.News;
import com.gut.practice.helpers.ViewTab;
import java.util.ArrayList;
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
    private News addNew = new News();
    
    public NewsCtrl() {
    }
     
    public void onTabChange(TabChangeEvent event) {
        
        System.out.println("<---------------- Mam onTabChange!");
        FacesMessage msg = new FacesMessage("Tab Changed", "Active Tab: " + event.getTab().getTitle() + "All options: " );
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
         
    public void onTabClose(TabCloseEvent event) {
        System.out.println("<---------------- Mam onTabClose!");
        FacesMessage msg = new FacesMessage("Tab Closed", "Closed tab: " + event.getTab().getTitle());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }


    public List<ViewTab> getOptionsList() {
        return optionsList;
    }
 
     public News getAddNew() {
         return addNew;
     };
 
     public void setAddNew(News addNew) {
         this.addNew = addNew;
     };
    
    
}
