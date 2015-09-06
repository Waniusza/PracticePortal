package com.gut.practice.entity;

import com.gut.practice.entity.user.PortalUser;
import com.gut.practice.util.OpinionName;
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

public class Opinion extends BaseModel {
    private long commentedEntityId;
   
    private OpinionName name;
    private String text;
    private PortalUser author = null;
    
    public Opinion() {
    }

    public Opinion setAuthor(PortalUser author) {
        this.author = author;
        return this;
    }

    public Opinion setCommentedEntityId(long commentedEntityId) {
        this.commentedEntityId = commentedEntityId;
        return this;
    }

    public Opinion setName(OpinionName name) {
        this.name = name;
        return this;
    }

    public Opinion setText(String text) {
        this.text = text;
        return this;
    }
    
    
    
    
    
}
