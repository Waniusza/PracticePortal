package com.gut.practice.entity.user;

import com.gut.practice.helpers.util.Speciality;
import javax.persistence.Entity;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor
public class Student extends PortalUser {
    private int indexID;
//    @OneToOne
//    private Practice practice;
    private Speciality speciality;
    
    public Student(){
        
    }
}
