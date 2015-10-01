package com.gut.practice.entity;

import com.gut.practice.entity.user.PortalUser;
import com.gut.practice.helpers.util.OpinionName;
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
   
    private String text;
    private PortalUser author = null;
    private Integer opinionNameEnum;
    
    public Opinion() {
    }

    public Opinion setAuthor(PortalUser author) {
        this.author = author;
        return this;
    }


    public Opinion setText(String text) {
        this.text = text;
        return this;
    }
    
    public OpinionName getOpinion(){
        return OpinionName.getOpinion(this.opinionNameEnum);
    }
    
    public Opinion setOpinionName(OpinionName opinion) {
        if (opinion == null) {
            this.opinionNameEnum = null;
        } else {
            this.opinionNameEnum = opinion.getId();
        }
        return this;
    }
    
    
    
    
    
}
