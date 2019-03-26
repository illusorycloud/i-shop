package com.illusory.i.shop.web.admin.dao;

import com.illusory.i.shop.domain.TbContent;
import com.illusory.i.shop.domain.TbContent;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 内容管理DAO
 *
 * @author illusory
 * @version 1.0.0
 * @date 2019/3/26
 */
@Repository
public interface TbContentDao {
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
    void insert(TbContent tbContent);

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
     * @param params 需要两个参数
     *               start 记录开始位置
     *               length 显示条数
     *               类似SQL中的limit start length
     * @return
     */
    List<TbContent> page(Map<String, Object> params);

    /**
     * 查询总记录条数
     *
     * @return
     */
    int count(TbContent tbContent);
}
