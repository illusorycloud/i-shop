package com.illusory.i.shop.commons.persistence;

import java.io.Serializable;

import lombok.Data;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2019/3/27 0027
 */
@Data
public abstract class BaseTreeEntity<T extends BaseEntity> extends BaseEntity implements Serializable {
    private T parent;
    private Boolean isParent;
}
