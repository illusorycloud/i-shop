package com.illusory.i.shop.web.admin.service;

import com.illusory.i.shop.commons.persistence.BaseService;
import com.illusory.i.shop.domain.TbContentCategory;

import java.util.List;

/**
 * @author illusory
 * @version 1.0.0
 * @date 2019/3/26
 */
public interface TbContentCategoryService extends BaseService<TbContentCategory> {
    /**
     * 根据父级节点 ID 查询所有子节点
     *
     * @param pid
     * @return
     */
    List<TbContentCategory> selectByPid(Long pid);
}
