package com.illusory.i.shop.web.admin.dao;

import com.illusory.i.shop.domain.TbContentCategory;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 内容分类管理DAO
 *
 * @author illusory
 * @version 1.0.0
 * @date 2019/3/26
 */
@Repository
public interface TbContentCategoryDao {
    /**
     * 查询所有
     *
     * @return
     */
    List<TbContentCategory> selectAll();
}
