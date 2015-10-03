/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gut.practice.controller.utils;

import com.gut.practice.entity.Subscribe;
import com.gut.practice.service.SubscribeService;
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
public class ListSubscriptionCtrl {
    private static final Logger log = LogManager.getLogger(ListSubscriptionCtrl.class);
    
    @EJB
    SubscribeService subscribeService;

    private List<Subscribe > allSubscriptions;
    
    
    public ListSubscriptionCtrl() {
        log.debug(" init");
    }

    public List<Subscribe> getAllSubscriptions() {
        setAllSubscriptions(subscribeService.getAll());
        log.debug("Mam subsktybcje : " + this.allSubscriptions);
        return this.allSubscriptions;
    }

    public void setAllSubscriptions(List<Subscribe> all) {
        this.allSubscriptions = all;
    }
    
    
    
}
