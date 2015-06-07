package com.gut.practice.entity;

import com.gut.practice.entity.enums.ConfirmationStatus;
import com.gut.practice.entity.user.Employer;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
    @Temporal(TemporalType.DATE)
    private Date dateFrom;
    @Temporal(TemporalType.DATE)
    private Date dateTo;
    private int hours;
    private Employer employer;
    private ConfirmationStatus confirmationStatus;
    
    public Practice() {
        
    }
}
