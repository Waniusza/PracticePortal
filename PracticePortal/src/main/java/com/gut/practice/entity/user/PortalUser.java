package com.gut.practice.entity.user;

import com.gut.practice.entity.BaseModel;
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

public class PortalUser extends BaseModel {
    private String firstName;
    private String lastName;
    private String email;
    
    public PortalUser() {
        
    }
}
