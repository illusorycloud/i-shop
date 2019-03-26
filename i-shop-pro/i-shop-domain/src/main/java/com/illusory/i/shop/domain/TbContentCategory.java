package com.illusory.i.shop.domain;

import com.illusory.i.shop.commoms.persistence.BaseEntity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author illusory
 * @version 1.0.0
 * @date 2019/3/26
 */
@Data
public class TbContentCategory extends BaseEntity {
    private Long parentId;
    private String name;
    private Integer status;
    private Integer sortOrder;
    private Boolean isParent;
    private TbContentCategory parent;
}
