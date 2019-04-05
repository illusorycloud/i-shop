package com.illusory.i.shop.service.content.api;

import com.github.pagehelper.PageInfo;
import com.illusory.i.shop.commons.domain.TbContent;

public interface TbContentService {
    /**
     * 分页查询
     * @param start
     * @param length
     * @param tbContent
     * @return
     */
    PageInfo<TbContent> page(int start, int length, TbContent tbContent);
}
