/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gut.practice.controller.news;

import com.gut.practice.entity.News;
import com.gut.practice.service.NewsService;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author janusz
 */
@ManagedBean
public class NewsCtrl {
    
    @EJB
    private NewsService newsService;
    private News addNew = new News();
    
    public NewsCtrl() {
        System.out.println("[NewsCtrl] init");
    }
     
   
    public void submit()  {
        System.out.println("SUBMITUJE : " + addNew.toString() + "!");
        newsService.add(addNew);
        addNew = new News();
    };
     
     public News getAddNew() {
         return addNew;
     };
 
     public void setAddNew(News addNew) {
         this.addNew = addNew;
     };
    
    
}
