package com.gut.practice.entity;

import com.gut.practice.util.ConfirmationStatus;
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

    public Practice() {
    }

    
    public Practice setConfirmationStatusChain(ConfirmationStatus confirmationStatus) {
        this.confirmationStatus = confirmationStatus;
        return this;
    }

    public Practice setDateFromChain(Date dateFrom) {
        this.dateFrom = dateFrom;
        return this;
    }

    public Practice setDateToChain(Date dateTo) {
        this.dateTo = dateTo;
        return this;
    }

    public Practice setDescriptionChain(String description) {
        this.description = description;
        return this;
    }

    public Practice setHoursChain(Integer hours) {
        this.hours = hours;
        return this;
    }

    public Practice setTitleChain(String title) {
        this.title = title;
        return this;
    }
    
    
    
}
