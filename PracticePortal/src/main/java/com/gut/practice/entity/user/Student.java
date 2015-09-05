package com.gut.practice.entity.user;

import com.gut.practice.entity.Practice;
import com.gut.practice.util.Speciality;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
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
    @OneToMany
    private List<Practice> practiceList;
    private Speciality speciality;
    
    public Student(){
        
    }
}
