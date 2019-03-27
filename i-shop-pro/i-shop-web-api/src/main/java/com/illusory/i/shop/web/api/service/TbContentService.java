package com.illusory.i.shop.web.api.service;

import com.illusory.i.shop.domain.TbContent;

import java.util.List;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2019/3/27 0027
 */
public interface TbContentService {
    /**
     * 根据类别 ID 查询内容列表
     * @param categoryId
     * @return
     */
    List<TbContent> selectByCategoryId(Long categoryId);
}
