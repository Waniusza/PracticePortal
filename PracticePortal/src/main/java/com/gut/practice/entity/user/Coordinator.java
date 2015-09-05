package com.gut.practice.entity.user;

import com.gut.practice.util.Speciality;
import com.gut.practice.entity.TimePeriod;
import java.util.List;
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

public class Coordinator extends PortalUser {
    private List<TimePeriod> availablity;
    private Speciality speciality;
   
}
