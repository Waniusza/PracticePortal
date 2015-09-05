/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gut.practice.entity;

import com.gut.practice.entity.user.PortalUser;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Getter;
import lombok.ToString;

/**
 *
 * @author kongo
 */
@Entity
@Getter
@ToString

public class News extends BaseModel {
    private String title;
    private String description;
    private static final long serialVersionUID = 1L;
    private String urlPhoto;  
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateFrom;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTo;
    @ManyToOne
    private PortalUser author = null;

    public News() {
    }

    
    public News setAuthor(PortalUser author) {
        this.author = author;
        return this;
    }

    public News setDescription(String description) {
        this.description = description;
        return this;
    }

    public News setTitle(String title) {
        this.title = title;
        return this;
    }

    public News setUrlPhoto(String urlPhoto) {
        this.urlPhoto = urlPhoto;
        return this;
    }

    public News setDateTo(Date dateTo) {
        this.dateTo = dateTo;
        return this;
    }

    public News setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
        return this;
    }

    
    
    
    

}
