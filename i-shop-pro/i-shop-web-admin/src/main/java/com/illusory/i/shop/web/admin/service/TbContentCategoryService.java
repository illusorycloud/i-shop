package com.illusory.i.shop.web.admin.service;

import com.illusory.i.shop.domain.TbContentCategory;

import java.util.List;

/**
 * @author illusory
 * @version 1.0.0
 * @date 2019/3/26
 */
public interface TbContentCategoryService {
    /**
     * 查询所有
     *
     * @return
     */
    List<TbContentCategory> selectAll();
}
