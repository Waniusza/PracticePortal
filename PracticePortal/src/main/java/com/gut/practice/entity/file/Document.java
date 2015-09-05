/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gut.practice.entity.file;

import com.gut.practice.entity.properties.Format;
import com.gut.practice.entity.user.PortalUser;
import javax.persistence.Entity;
import lombok.Getter;
import lombok.ToString;

/**
 *
 * @author kongo
 */
@Entity
@Getter
@ToString
public class Document extends BaseFile {

    private Format format;
    private String urlDocument;

    public Document() {
    }

    public Document setAuthor(PortalUser author) {
        this.author = author;
        return this;
    }

    public Document setDescription(String description) {
        this.description = description;
        return this;
    }

    public Document setTitle(String title) {
        this.title = title;
        return this;
    }

    public Document setFormat(Format format) {
        this.format = format;
        return this;
    }

    public Document setUrlDocument(String urlDocument) {
        this.urlDocument = urlDocument;
        return this;
    }

}
