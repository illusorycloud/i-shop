package com.illusory.i.shop.domain;

import com.illusory.i.shop.commons.persistence.BaseTreeEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * 内容分类实体类
 *
 * @author illusory
 * @version 1.0.0
 * @date 2019/3/26
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class TbContentCategory extends BaseTreeEntity {
    private Long parentId;
    @Length(min = 1, max = 20, message = "分类名称必须介于 1 - 20 位之间")
    private String name;
    private Integer status;
    @NotNull(message = "排序不能为空")
    private Integer sortOrder;
    private Boolean isParent;
    private TbContentCategory parent;
}
