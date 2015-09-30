package com.gut.practice.entity;

import com.gut.practice.entity.user.PortalUser;
import javax.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
@NoArgsConstructor

public class Employer extends PortalUser {
    
    private String comapnyName;
    // TODO adress, asigned to student
    
}
