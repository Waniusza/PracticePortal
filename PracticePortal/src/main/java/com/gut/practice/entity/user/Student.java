package com.gut.practice.entity.user;

import com.gut.practice.entity.Practice;
import com.gut.practice.entity.enums.Speciality;
import java.util.List;
import javax.persistence.OneToMany;
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

public class Student extends PortalUser {
    private int indexID;
    @OneToMany
    private List<Practice> practiceList;
    private Speciality sspeciality;
}
