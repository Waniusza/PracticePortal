package com.gut.practice.entity.user;

import com.gut.practice.entity.BaseModel;
import javax.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author kongo
 */
@Entity
@Getter
@Setter

public class PortalUser extends BaseModel {
    private String firstName;
    private String lastName;
    private String email;
    
    public PortalUser() {
    }
}
