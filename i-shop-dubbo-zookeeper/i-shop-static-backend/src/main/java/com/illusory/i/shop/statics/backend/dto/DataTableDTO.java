package com.illusory.i.shop.statics.backend.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * Bootstrap DataTable 数据传输对象
 *
 * @author illusory
 * @version 1.0.0
 * @date 2019/4/4
 */
@Data
public class DataTableDTO<T> implements Serializable {
    private int draw;
    private long recordsTotal;
    private long recordsFiltered;
    private List<T> data;
    private String error;
}
