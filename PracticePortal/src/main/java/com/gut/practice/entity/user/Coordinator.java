package com.gut.practice.entity.user;

import com.gut.practice.entity.TimePeriod;
import com.gut.practice.helpers.util.Speciality;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author kongo
 */
//@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor

@Deprecated

public class Coordinator extends PortalUser {
    private List<TimePeriod> availablity;
    private Speciality speciality;
   
}
