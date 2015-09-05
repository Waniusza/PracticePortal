package com.gut.practice.service.login;

import com.gut.practice.util.Permission;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author kongo
 */

@Getter
@Setter
@ToString

public class User {   
    private String name;
    private String password;
    private List<Permission> permissions;
    
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
}