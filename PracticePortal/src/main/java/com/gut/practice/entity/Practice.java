package com.gut.practice.entity;

import com.gut.practice.enums.ConfirmationStatus;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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

public class Practice extends BaseModel {
    
    private String title;
    //TODO Adnotation for Long String
    private String description;
    
    @Temporal(TemporalType.DATE)
    private Date dateFrom;
    @Temporal(TemporalType.DATE)
    private Date dateTo;
    private Integer hours;
//    @ManyToOne
//    private Employer employer;
    private ConfirmationStatus confirmationStatus;
    
}
