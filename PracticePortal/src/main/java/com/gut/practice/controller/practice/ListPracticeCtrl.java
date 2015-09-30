/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gut.practice.controller.practice;

import com.gut.practice.entity.Practice;
import com.gut.practice.service.PracticeService;
import java.util.List;
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
public class ListPracticeCtrl {

    private static final Logger log = LogManager.getLogger(ListPracticeCtrl.class);

    @EJB
    private PracticeService practiceService;

    private List<Practice> practices;

    public ListPracticeCtrl() {
        log.debug("[ListPracticeCtrl] init");
    }

    @PostConstruct
    private void init() {
        _getData();

    }

    private void _getData() {
        log.debug("[ListCompanyCtrl] _getData");
        practices = practiceService.getAll();
    }

    public List<Practice> getPractices() {
        return practices;
    }

    public void setPractices(List<Practice> practices) {
        this.practices = practices;
    }

}
