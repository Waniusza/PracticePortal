/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gut.practice.entity.file;

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

public class News extends BaseFile {
    private String urlPhoto;
}
