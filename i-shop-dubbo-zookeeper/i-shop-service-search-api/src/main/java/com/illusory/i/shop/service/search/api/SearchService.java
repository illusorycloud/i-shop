package com.illusory.i.shop.service.search.api;

import com.illusory.i.shop.service.search.domain.TbItemResult;

import java.util.List;

/**
 * Solr搜索服务
 *
 * @author illusory
 * @version 1.0.0
 * @date 2019/4/9
 */
public interface SearchService {
    /**
     * 搜索商品
     *
     * @param query 查询关键字
     * @param page  页码
     * @param rows  笔数
     * @return
     */
    List<TbItemResult> search(String query, int page, int rows);
}
