/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gut.practice.controller;

import com.gut.practice.entity.file.News;
import com.gut.practice.service.NewsService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author janusz
 */
@ManagedBean
public class MainCtrl implements Serializable {

    @EJB
    NewsService newsService;
//    @EJB
//    FaqService faqService;

    private final List<String> availbleRoles = new ArrayList<>();
    private String selectedRole;

    private final List<String> availableOpinions = new ArrayList<>();
    private String selectedOpinion;

    public MainCtrl() {
        System.out.println("[MainCtrl] init");
    }

    @PostConstruct
    private void init() {
        initNews();
        initRoles();
        initOptions();
//        initFaq();
    }

    public List<String> getAvailableOpinions() {
        return availableOpinions;
    }

    public String getSelectedOpinion() {
        return selectedOpinion;
    }

    public final void setSelectedOpinion(String selectedOpinion) {
        this.selectedOpinion = selectedOpinion;
    }

    @Deprecated
    private void initOptions() {
        if (availableOpinions.isEmpty()) {
            availableOpinions.add("1_POOR");
            availableOpinions.add("2_WEEK");
            availableOpinions.add("3_OK");
            availableOpinions.add("4_NICE");
            availableOpinions.add("5_GREAT");
            setSelectedOpinion(availableOpinions.get(2));
        };
    }

    @Deprecated
    private void initRoles() {
        if (availbleRoles.isEmpty()) {
            this.selectedRole = null;
            availbleRoles.add("STUDENT");
            availbleRoles.add("COORDINATOR");
            availbleRoles.add("EMPLOYER");
            selectedRole = availbleRoles.get(0);
        };
    }

    @Deprecated
    private void initNews() {
        if (newsService.getAll().isEmpty()) {
            String desc = "";
            for (int i = 1; i < 5; i++) {
                desc = desc.concat("Description-" + i + "  ");

                News oneNew = new News(
                        "Tytuł " + i,
                        desc,
                        "url" + i,
                        null, null, null);
                oneNew.setTitle("Title " + i);
                oneNew.setUrlPhoto("url");
                System.out.println("I'm adding " + oneNew.getTitle());
                newsService.add(oneNew);
            }
        }
    }
//
//    private void initFaq() {
//        if (faqService.getAll().isEmpty()) {
//            Faq question = new Faq();
//            for (int i = 1; i < 5; i++) {
//                question = new Faq();
//                question.setQuestion("QUESTION " + i);
//                question.setAnswer("ANSWER " + i);
//                faqService.add(question);
//            }
//        }
//    }

}
