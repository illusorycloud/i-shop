package com.illusory.i.shop.commons.persistence;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2019/3/26 0026
 */
public abstract class BaseEntity implements Serializable {
    private Long id;
    private Date created;
    private Date updated;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}
