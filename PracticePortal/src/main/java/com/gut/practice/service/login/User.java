package com.gut.practice.service.login;

import com.gut.practice.entity.BaseModel;
import com.gut.practice.util.Permission;
import java.util.List;
import javax.persistence.Entity;
import lombok.Getter;
import lombok.ToString;

/**
 *
 * @author kongo
 */

//@Entity
@Getter
@ToString

public class User extends BaseModel {   
    private String name;
    private String password;
    private List<Permission> permissions;
    
 
    public User setName(String name) {
        this.name = name;
        return this;
    }
    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public User setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
        return this;
    }
    
}