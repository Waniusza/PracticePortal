package com.gut.practice.entity;

import com.gut.practice.util.ConfirmationStatus;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author kongo
 */

@Entity
@Getter
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

    public Practice setConfirmationStatus(ConfirmationStatus confirmationStatus) {
        this.confirmationStatus = confirmationStatus;
        return this;
    }

    public Practice setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
        return this;
    }

    public Practice setDateTo(Date dateTo) {
        this.dateTo = dateTo;
        return this;
    }

    public Practice setDescription(String description) {
        this.description = description;
        return this;
    }

    public Practice setHours(Integer hours) {
        this.hours = hours;
        return this;
    }

    public Practice setTitle(String title) {
        this.title = title;
        return this;
    }
    
    
    
}
