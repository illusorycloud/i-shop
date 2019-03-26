package com.illusory.i.shop.web.admin.service.impl;

import com.illusory.i.shop.domain.TbContentCategory;
import com.illusory.i.shop.web.admin.dao.TbContentCategoryDao;
import com.illusory.i.shop.web.admin.service.TbContentCategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 内容分类管理
 *
 * @author illusory
 * @version 1.0.0
 * @date 2019/3/26
 */
@Service
public class TbContentCategoryServiceImpl implements TbContentCategoryService {
    @Autowired
    private TbContentCategoryDao categoryDao;

    @Override
    public List<TbContentCategory> selectAll() {
        return categoryDao.selectAll();
    }



}
