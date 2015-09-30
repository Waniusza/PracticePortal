/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gut.practice.controller.practice;

import com.gut.practice.entity.Company;
import com.gut.practice.entity.Practice;
import com.gut.practice.helpers.util.JobOfferType;
import com.gut.practice.helpers.util.Speciality;
import com.gut.practice.service.CompanyService;
import com.gut.practice.service.PracticeService;
import java.util.ArrayList;
import java.util.Date;
import java.util.EnumSet;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author janusz
 */
@ManagedBean
public class AddPracticeCtrl {

    private static final Logger log = LogManager.getLogger(AddPracticeCtrl.class);

    @EJB
    CompanyService companyService;
    @EJB
    PracticeService practiceService;

    List<Company> availableCompanies = new ArrayList<>();
    EnumSet<JobOfferType> availableTypes = EnumSet.allOf(JobOfferType.class);
    EnumSet<Speciality> availableSpecialities = EnumSet.allOf(Speciality.class);
//    EnumSet<Speciality> availableSpecialities = EnumSet.allOf(Speciality.class);
    Company company;
    String title;
    JobOfferType type;
    String duty;
    String salary;
    String description;
    List<String> specialities;
    Date dateFrom;
    Date dateTo;

    public AddPracticeCtrl() {
        log.debug("[AddEmployeeCtrl] init");
    }

    public void submit() {
        Practice practice = new Practice()
                .setTitleChain(title)
                .setDateFromChain(dateFrom)
                .setDateToChain(dateTo)
                .setDescriptionChain(description);

        practice.setType(type);
        practice.setCompany(company);
        practice.setDuty(duty);

        log.debug("SUBMITUJE : " + practice + "!");
        practiceService.add(practice);
    }

    public List<Company> getAvailableCompanies() {
        if (availableCompanies.isEmpty()) {
            availableCompanies = companyService.getAll();
        }
        return availableCompanies;
    }

    public EnumSet<JobOfferType> getAvailableTypes() {
        return availableTypes;
    }

    public EnumSet<Speciality> getAvailableSpecialities() {
        return availableSpecialities;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public JobOfferType getType() {
        return type;
    }

    public void setType(JobOfferType type) {
        this.type = type;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public String getDuty() {
        return duty;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getSalary() {
        return salary;
    }

    public List<String> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(List<String> specialities) {
        this.specialities = specialities;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

}
