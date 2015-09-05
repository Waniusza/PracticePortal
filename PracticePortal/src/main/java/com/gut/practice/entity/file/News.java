/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gut.practice.entity.file;

import com.gut.practice.entity.BaseModel;
import com.gut.practice.entity.user.PortalUser;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author kongo
 */
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor

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

    

}
