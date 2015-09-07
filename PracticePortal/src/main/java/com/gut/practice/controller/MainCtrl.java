/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gut.practice.controller;

import com.gut.practice.entity.Faq;
import com.gut.practice.entity.JobOffer;
import com.gut.practice.entity.News;
import com.gut.practice.entity.Practice;
import com.gut.practice.entity.user.PortalUser;
import com.gut.practice.service.FaqService;
import com.gut.practice.service.JobOfferService;
import com.gut.practice.service.NewsService;
import com.gut.practice.service.PracticeService;
import com.gut.practice.service.SubscribeService;
import com.gut.practice.service.user.PortalUserService;
import com.gut.practice.util.ConfirmationStatus;
import com.gut.practice.util.OpinionName;
import com.gut.practice.util.Permission;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
    @EJB
    FaqService faqService;
    @EJB
    PracticeService practiceService;
    @EJB
    JobOfferService jobOfferService;
    @EJB
    SubscribeService subscribeService;
    @EJB
    PortalUserService userService;

    private final List<String> availbleRoles = new ArrayList<>();
    private String selectedRole;

    private OpinionName[] availableOpinions;
    private String selectedOpinion = "";
    private String newOpinion = "";

    private String newSubscribe = "";

    public MainCtrl() {
        System.out.println("[MainCtrl] init");
    }

    @PostConstruct
    private void init() {
        initNews();
        initRoles();
        initOptions();
        initFaq();
        initPractice();
        initJobOffers();
        initUsers();
    }

    public OpinionName[] getAvailableOpinions() {
        return availableOpinions;
    }

    public String getSelectedOpinion() {
        return selectedOpinion;
    }

    public void setSelectedOpinion(String selectedOpinion) {
        this.selectedOpinion = selectedOpinion;
    }

    public void setNewOpinion(String newOpinion) {
        this.newOpinion = newOpinion;
    }

    
    public String getNewOpinion() {
        return newOpinion;
    }

    public String getNewSubscribe() {
        return newSubscribe;
    }

    public void setNewSubscribe(String newSubscribe) {
        this.newSubscribe = newSubscribe;
    }

    public void addNewSubscriber() {
        System.out.println("[MainCtrl] addNewSubscribe - newSubscribe " + newSubscribe);
        subscribeService.add(newSubscribe);
    }

    @Deprecated
    private void initOptions() {
        availableOpinions = OpinionName.values();
        setSelectedOpinion(availableOpinions[2].name());
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

                News oneNew = new News();
                oneNew.setDescription(desc);
                oneNew.setTitle("Title " + i);
                oneNew.setUrlPhoto("url");
                newsService.add(oneNew);
            }
        }
    }

    @Deprecated
    private void initFaq() {
        if (faqService.getAll().isEmpty()) {
            Faq question = new Faq();
            for (int i = 1; i < 5; i++) {
                question = new Faq();
                question.setQuestion("QUESTION " + i);
                question.setAnswer("ANSWER " + i);
                faqService.add(question);
            }
        }
    }

    @Deprecated
    private void initPractice() {
        if (practiceService.getAll().isEmpty()) {
            Practice practice;
            for (int i = 1; i < 5; i++) {
                practice = new Practice();
                practice.setTitle("Praktyka nr. " + i);
                practice.setDescription("To jest opis dla praktyki nr" + i);
                practice.setConfirmationStatus(ConfirmationStatus.values()[ConfirmationStatus.values().length % i]);
                practice.setHours(i * 55 % 80);
                practiceService.add(practice);
                practice.setDescription("Added practice" + practice.getTitle());
            }
        }
    }

    @Deprecated
    private void initJobOffers() {
        if (jobOfferService.getAll().isEmpty()) {
            JobOffer jobOffer;
            for (int i = 1; i < 5; i++) {
                jobOffer = new JobOffer();
                jobOffer.setMainDuty("Duty nr" + i);
                jobOffer.setSalaryMax(2000 * i % 2500);
                jobOffer.setDateTo(new Date());
                jobOfferService.add(jobOffer);
            }
        }
    }

    @Deprecated
    private void initUsers() {
        System.out.println("[MainCtrl] initUsers");
        if (userService.getAll().isEmpty()) {
            System.out.println("[MainCtrl] initUsers EMPTY");
            List<Permission> permStud = new ArrayList<>();
            permStud.add(Permission.STUDENT);
            List<Permission> permCord = new ArrayList<>();
            permCord.add(Permission.COORDINATOR);
            List<Permission> permEmp = new ArrayList<>();
            permEmp.add(Permission.EMPLOYEER);
            PortalUser user1 = new PortalUser()
                    .setName("Janusz")
                    .setPassword("wania")
                    .setPermissions(permStud);
            userService.add(user1);
            
            PortalUser user2 = new PortalUser()
                    .setName("Patryk")
                    .setPassword("kongo")
                    .setPermissions(permCord);
            userService.add(user2);
            
            PortalUser user3 = new PortalUser()
                    .setName("Patryk")
                    .setPassword("profesor")
                    .setPermissions(permEmp);
            userService.add(user3);
        }
    }

}
