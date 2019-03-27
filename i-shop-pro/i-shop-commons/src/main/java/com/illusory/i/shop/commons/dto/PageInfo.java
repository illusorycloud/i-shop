package com.illusory.i.shop.commons.dto;

import com.illusory.i.shop.commons.persistence.BaseEntity;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 分页对象
 *
 * @author illusory
 * @version 1.0.0
 * @date 2019/3/26
 */
@Data
public class PageInfo<T extends BaseEntity> implements Serializable {
    private int draw;
    /**
     * 总记录数
     */
    private int recordsTotal;
    /**
     * 过滤后的记录数
     */
    private int recordsFiltered;
    /**
     * 数据
     */
    private List<T> data;
    /**
     * 错误提示信息
     */
    private String error;
}
