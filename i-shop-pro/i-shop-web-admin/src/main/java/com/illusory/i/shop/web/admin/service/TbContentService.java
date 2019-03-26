package com.illusory.i.shop.web.admin.service;

import com.illusory.i.shop.commoms.dto.BaseResult;
import com.illusory.i.shop.commoms.dto.PageInfo;
import com.illusory.i.shop.domain.TbContent;
import com.illusory.i.shop.domain.TbUser;

import java.util.List;
import java.util.Map;

/**
 * 内容管理Service
 *
 * @author illusory
 * @version 1.0.0
 * @date 2019/3/26
 */
public interface TbContentService {
    /**
     * 查询全部信息
     *
     * @return List<TbContent>
     */
    List<TbContent> selectAll();

    /**
     * 新增
     *
     * @param tbContent
     */
    BaseResult save(TbContent tbContent);

    /**
     * 删除
     *
     * @param id
     */
    void delete(Long id);

    /**
     * 根据ID查询
     *
     * @param id
     * @return
     */
    TbContent getById(Long id);

    /**
     * 更新信息
     *
     * @param tbContent
     */
    void update(TbContent tbContent);

    /**
     * 搜索
     *
     * @return
     */
    List<TbContent> search(TbContent tbContent);

    /**
     * 根据ID批量删除
     *
     * @param ids
     */
    void deleteMulti(String[] ids);

    /**
     * 分页查询
     *
     * @param start
     * @param length
     * @param draw
     * @param tbContent
     * @return
     */
    PageInfo<TbContent> page(int start, int length, int draw, TbContent tbContent);

    /**
     * 查询总记录条数
     *
     * @return
     */
    int count(TbContent tbContent);
}
