/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gut.practice.controller.utils;

import com.gut.practice.entity.Opinion;
import com.gut.practice.service.OpinionService;
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
public class ListOpinionCtrl {
    private static final Logger log = LogManager.getLogger(ListOpinionCtrl.class);
    
    @EJB
    OpinionService opinionService;

    private List<Opinion> allOpinions;
    
    
    public ListOpinionCtrl() {
        log.debug(" init");
    }

    public List<Opinion> getAllOpinions() {
        setAllOpinions(opinionService.getAll());
        return this.allOpinions;
    }

    public void setAllOpinions(List<Opinion> allOpinions) {
        this.allOpinions = allOpinions;
    }
    
    
    
}
