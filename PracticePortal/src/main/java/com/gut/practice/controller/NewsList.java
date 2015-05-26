/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gut.practice.controller;

import com.gut.practice.entity.file.News;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;

/**
 *
 * @author student
 */

@Named
public class NewsList {
    
    List<News> news = new ArrayList<>();
    
    
    @PostConstruct
    public void init() {
        News newww = new News();
        String desc = "";
        for (int i=1; i < 5; i++ ) {
            newww = new News();
            newww.setTitle("Title " + i);
            newww.setDateCreate(new Date());
            newww.setUrlPhoto("url");
            desc = desc.concat("Descri[ption");
            newww.setDescription(desc);
    System.out.println("I'm adding " + newww.getTitle());
            news.add(newww);
        }
    System.out.println(news.get(0).getTitle());
    System.out.println(news.get(1).getTitle());
    System.out.println(news.get(2).getTitle());
    System.out.println(news.get(3).getTitle());
        
    }
    
    public  List<News> getNews () {
        return news;
    }
}
