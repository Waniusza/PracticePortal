package com.gut.practice.entity;

import com.gut.practice.entity.user.Employer;
import java.util.Date;
import javax.persistence.Entity;
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

public class Practice extends BaseModel {
    private Date dateFrom;
    private Date dateTo;
    private int hours;
    private Employer employer;
}
