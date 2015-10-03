/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gut.practice.controller;

import com.gut.practice.entity.Company;
import com.gut.practice.entity.JobOffer;
import com.gut.practice.entity.News;
import com.gut.practice.entity.Practice;
import com.gut.practice.entity.user.PortalUser;
import com.gut.practice.helpers.util.ConfirmationStatus;
import com.gut.practice.helpers.util.OpinionName;
import com.gut.practice.helpers.util.Permission;
import com.gut.practice.helpers.util.SubscribeType;
import com.gut.practice.service.CompanyService;
import com.gut.practice.service.FaqService;
import com.gut.practice.service.JobOfferService;
import com.gut.practice.service.NewsService;
import com.gut.practice.service.OpinionService;
import com.gut.practice.service.PracticeService;
import com.gut.practice.service.SubscribeService;
import com.gut.practice.service.user.PortalUserService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.EnumSet;
import java.util.List;
import java.util.Random;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author janusz
 */
@ManagedBean
public class MainCtrl implements Serializable {

    private static final Logger log = LogManager.getLogger(MainCtrl.class);

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
    OpinionService opinionService;
    @EJB
    PortalUserService userService;
    @EJB
    private CompanyService companyService;

    private final List<String> availbleRoles = new ArrayList<>();
    private String selectedRole;
    private Random generator;

    private EnumSet<OpinionName> availableOpinions;
    private String newOpinion = "";
    private OpinionName selectedOpinion = OpinionName.OK;

    private final EnumSet<SubscribeType> availableSubType = EnumSet.allOf(SubscribeType.class);
    private String newSubscribe = "";
    private SubscribeType selectedSubType = SubscribeType.ALL;

    public MainCtrl() {
        this.availableOpinions = EnumSet.allOf(OpinionName.class);
        log.debug("[MainCtrl] init");
        generator = new Random();
    }

    @PostConstruct
    private void init() {
        initNews();
        initRoles();
        initOptions();
        initCompany();
//        initPractice();
        initJobOffers();
        initUsers();
    }

    public void addNewSubscriber() {
        log.debug(" addNewSubscribe - newSubscribe " + newSubscribe);
        log.debug(" result :" + subscribeService.add(newSubscribe, selectedSubType));

    }

    public void addNewOpinion() {
        log.debug(" addNewOpinion - newOpinion " + newOpinion);
        log.debug("result : " + opinionService.add(newOpinion, selectedOpinion));

    }

    @Deprecated
    private void initOptions() {
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
        log.debug("[MainCtrl] initUsers");
        if (userService.getAll().isEmpty()) {
            log.debug("[MainCtrl] initUsers EMPTY");
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

    @Deprecated
    private void initCompany() {
        Random generator = new Random();
        log.debug("[MainCtrl] initCompany");
        if (companyService.getAll().isEmpty()) {
            log.debug("[MainCtrl] initCompany EMPTY");
            for (int i = 1; i < 5; i++) {
                Company newCompany = new Company()
                        .setCompanyName("Company " + i)
                        .setHRfirstName("Name" + i)
                        .setHRlastName("Surname" + i)
                        .setHRphone(Integer.toString((generator.nextInt(1000000000))));
                companyService.add(newCompany);
            }
        }
    }

    @Deprecated
    private void initPractice() {
        List<Company> allCompanies = companyService.getAll();
        if (practiceService.getAll().isEmpty()) {
            Practice practice;
            for (int i = 1; i < 5; i++) {
                practice = new Practice();
                practice.setTitleChain("Praktyka nr. " + i);
                practice.setDuty("Duty. " + i);
                practice.setCompany(allCompanies.get(generator.nextInt(allCompanies.size() - 1)));
                practice.setDescription("To jest opis dla praktyki nr" + i);
                practice.setConfirmationStatus(ConfirmationStatus.values()[ConfirmationStatus.values().length % i]);
                practice.setHours(i * 55 % 80);
                practice.setDateFrom(new Date());
                practice.setDateTo(new Date(new Date().getTime() + 3532432));
                practiceService.add(practice);
                practice.setDescription("Added practice" + practice.getTitle());
            }
        }
    }

    public EnumSet<OpinionName> getAvailableOpinions() {
        return availableOpinions;
    }

    public OpinionName getSelectedOpinion() {
        return selectedOpinion;
    }

    public void setSelectedOpinion(OpinionName selectedOpinion) {
        this.selectedOpinion = selectedOpinion;
    }

    public EnumSet<SubscribeType> getAvailableSubType() {
        return availableSubType;
    }

    public SubscribeType getSelectedSubType() {
        return selectedSubType;
    }

    public void setSelectedSubType(SubscribeType selectedSubType) {
        this.selectedSubType = selectedSubType;
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
}
