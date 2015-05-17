package com.gut.practice.entity;

import com.gut.practice.entity.user.PortalUser;
import java.util.List;
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

public class Opinion extends BaseModel {
    private long commentedEntityId;
    private List<Opinion> comments = null;
    private String text;
    private PortalUser author = null;
    
}
