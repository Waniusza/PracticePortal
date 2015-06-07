package com.gut.practice.entity.file;

import com.gut.practice.entity.BaseModel;
import com.gut.practice.entity.user.PortalUser;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author kongo
 */

@MappedSuperclass
@Getter
@Setter

public abstract class BaseFile extends BaseModel {
    private String title;
    private String description;
    @ManyToOne
    private PortalUser author = null;
}
