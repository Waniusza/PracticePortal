package com.gut.practice.entity;

import com.gut.practice.entity.user.PortalUser;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
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
    @OneToMany
    private List<Opinion> comments = null;
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

    public Opinion setComments(List<Opinion> comments) {
        this.comments = comments;
        return this;
    }

    public Opinion setText(String text) {
        this.text = text;
        return this;
    }
    
    
    
    
    
}
