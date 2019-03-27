package com.illusory.i.shop.web.api.service.impl;

import com.illusory.i.shop.domain.TbContent;
import com.illusory.i.shop.domain.TbContentCategory;
import com.illusory.i.shop.web.api.dao.TbContentDao;
import com.illusory.i.shop.web.api.service.TbContentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2019/3/27 0027
 */
@Service
public class TbContentServiceImpl implements TbContentService {
    @Autowired
    private TbContentDao tbContentDao;

    @Override
    public List<TbContent> selectByCategoryId(Long categoryId) {
        TbContentCategory tbContentCategory = new TbContentCategory();
        tbContentCategory.setId(categoryId);

        TbContent tbContent = new TbContent();
        tbContent.setTbContentCategory(tbContentCategory);

        return tbContentDao.selectByCategoryId(tbContent);
    }
}
