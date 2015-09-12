package com.gut.practice.entity.user;

import com.gut.practice.entity.BaseModel;
import com.gut.practice.util.Permission;
import java.util.List;
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
    private String name;
    private String password;
    private boolean loged;
    //private LoginContext loginContext;
    
    private String firstName;
    private String lastName;
    private String email;
    private List<Permission> permissions;
    
    public PortalUser() {
        loged = false;
    }
    
    public PortalUser setName(String name) {
        this.name = name;
        return this;
    }
    public PortalUser setPassword(String password) {
        this.password = password;
        return this;
    }

    public PortalUser setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
        return this;
    }
}
