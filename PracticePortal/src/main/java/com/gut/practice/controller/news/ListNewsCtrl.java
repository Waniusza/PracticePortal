/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gut.practice.controller.news;

import com.gut.practice.entity.News;
import com.gut.practice.service.NewsService;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author student
 */
@ManagedBean
public class ListNewsCtrl {

    @EJB
    NewsService newsService;
    List<News> news = new ArrayList<>();

    public ListNewsCtrl() {
        System.out.println("[NewsListCtrl] init");
    }

    @PostConstruct
    public void init() {

        news = newsService.getAll();
        System.out.println("[NewsListCtrl] init : Mam do wy≤świetlenia wiadomości: " + news.size());
    }

    public List<News> getNews() {
        return news;
    }
}
