package com.gut.practice.entity.file;

import com.gut.practice.entity.BaseModel;
import com.gut.practice.entity.user.PortalUser;
import javax.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author kongo
 */

@MappedSuperclass
@Getter
@Setter
@ToString

public abstract class BaseFile extends BaseModel {
    private String title;
    private String description;
    private PortalUser author = null;
}
