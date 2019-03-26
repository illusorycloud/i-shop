package com.illusory.i.shop.web.admin.service.impl;

import com.illusory.i.shop.commons.dto.BaseResult;
import com.illusory.i.shop.commons.dto.PageInfo;
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

    @Override
    public BaseResult save(TbContentCategory entity) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public TbContentCategory getById(Long id) {
        return null;
    }

    @Override
    public void update(TbContentCategory entity) {

    }

    @Override
    public void deleteMulti(String[] ids) {

    }

    @Override
    public PageInfo<TbContentCategory> page(int start, int length, int draw, TbContentCategory entity) {
        return null;
    }

    @Override
    public int count(TbContentCategory entity) {
        return 0;
    }


    @Override
    public List<TbContentCategory> selectByPid(Long pid) {
        return null;
    }
}
