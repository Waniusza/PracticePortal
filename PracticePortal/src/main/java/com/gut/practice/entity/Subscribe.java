package com.gut.practice.entity;

import com.gut.practice.helpers.util.SubscribeType;
import javax.persistence.Entity;
import lombok.Getter;
import lombok.ToString;

/**
 *
 * @author janusz
 */

@Entity
@Getter
@ToString

public class Subscribe extends BaseModel{
    
    private String email;
    private Boolean active = true;
    private Integer subscribeTypeENUM;

    
    public Subscribe() {
    }
    
    public Subscribe setActive(Boolean active) {
        this.active = active;
        return this;
    }

    public Subscribe setEmail(String email) {
        this.email = email;
        return this;
    }
    

    public SubscribeType getSubscribeType () {
        return SubscribeType.getType(this.subscribeTypeENUM);
    }
 
    public Subscribe setSubscribeType(SubscribeType type) {
 
        if (type == null) {
            this.subscribeTypeENUM = null;
        } else {
            this.subscribeTypeENUM = type.getId();
        }
        return this;
    }
}
