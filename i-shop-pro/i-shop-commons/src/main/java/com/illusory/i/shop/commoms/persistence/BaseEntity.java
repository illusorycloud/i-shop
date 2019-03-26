package com.illusory.i.shop.commoms.persistence;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2019/3/26 0026
 */
@Getter
@Setter
@ToString
public abstract class BaseEntity implements Serializable {
    private Long id;
    private Date created;
    private Date updated;
}
