package com.illusory.i.shop.web.api.dao;

import com.illusory.i.shop.domain.TbContent;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author illusory
 * @version 1.0.0
 * @date 2019/3/27
 */
@Repository
public interface TbContentDao {
    /**
     * 根据类别 ID 查询内容列表
     * @param tbContent
     * @return
     */
    List<TbContent> selectByCategoryId(TbContent tbContent);
}
