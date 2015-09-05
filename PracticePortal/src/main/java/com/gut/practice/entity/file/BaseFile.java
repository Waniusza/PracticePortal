package com.gut.practice.entity.file;

import com.gut.practice.entity.BaseModel;
import com.gut.practice.entity.user.PortalUser;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import lombok.Getter;

/**
 *
 * @author kongo
 */

@MappedSuperclass
@Getter

public abstract class BaseFile extends BaseModel {
    protected String title;
    protected String description;
    @ManyToOne
    protected PortalUser author = null;

    public BaseFile() {
    }
    
    
}
