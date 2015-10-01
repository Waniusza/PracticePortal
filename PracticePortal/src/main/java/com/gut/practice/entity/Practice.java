package com.gut.practice.entity;

import com.gut.practice.helpers.util.ConfirmationStatus;
import com.gut.practice.helpers.util.JobOfferType;
import com.gut.practice.helpers.util.Speciality;
import java.util.ArrayList;
import java.util.Date;
import java.util.EnumSet;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Getter;
import lombok.ToString;

/**
 *
 * @author kongo
 */
@Entity
@Getter
@ToString

public class Practice extends BaseModel {

    private String title;
    //TODO Adnotation for Long String
    private String description;
    private String duty;

    @Temporal(TemporalType.DATE)
    private Date dateFrom;
    @Temporal(TemporalType.DATE)
    private Date dateTo;
    private Integer hours;
    @ManyToOne
    private Company company;
    private ConfirmationStatus confirmationStatus;
    private Integer typeENUM;
    private List<Integer> specialitiesENUM;

    public Practice() {
    }

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

    public Practice setDuty(String duty) {
        this.duty = duty;
        return this;
    }

    public Practice setHours(Integer hours) {
        this.hours = hours;
        return this;
    }

    public Practice setTitleChain(String title) {
        this.title = title;
        return this;
    }

    public Practice setCompany(Company company) {
        this.company = company;
        return this;
    }

    public EnumSet<Speciality> getSpecialities() {
        EnumSet<Speciality> result = EnumSet.noneOf(Speciality.class);
        this.specialitiesENUM.forEach(specNum -> {
            result.add(Speciality.getType(specNum));
        });
        return result;
    }

    public Practice setSpecialities(EnumSet<Speciality> specialities) {
        List<Integer> result = new ArrayList<>();
        if (specialities != null) {
            for (Speciality speciality : specialities) {
                result.add(speciality.getId());
            }
        }
        this.specialitiesENUM = result;
        return this;
    }

    public JobOfferType getType() {
        return JobOfferType.getType(typeENUM);
    }

    ;
    public Practice setType(JobOfferType type) {
        if (type == null) {
            this.typeENUM = null;
        } else {
            this.typeENUM = type.getId();
        }

        return this;
    }

}
