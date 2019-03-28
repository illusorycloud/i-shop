package com.illusory.i.shop.commons.persistence;

import lombok.Data;

import java.io.Serializable;

/**
 * 树形实体类基类
 * @author illusory
 * @version 1.0.0
 * @date 2019/3/27
 */
@Data
public abstract class BaseTreeEntity<T extends BaseEntity> extends BaseEntity implements Serializable {
    private T parent;
    private Boolean isParent;
}
