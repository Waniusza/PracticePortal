/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gut.practice.entity.file;

import com.gut.practice.entity.BaseModel;
import com.gut.practice.entity.enums.Format;
import javax.persistence.Entity;
import lombok.Getter;
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

public class Document extends BaseFile{
   
    private Format format;
    private String urlDocument;
    
}