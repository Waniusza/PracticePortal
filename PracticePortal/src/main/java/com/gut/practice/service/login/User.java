package com.gut.practice.service.login;

import com.gut.practice.util.Permission;
import java.util.List;
import lombok.Getter;
import lombok.ToString;

/**
 *
 * @author kongo
 */

@Getter
@ToString

public class User {   
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