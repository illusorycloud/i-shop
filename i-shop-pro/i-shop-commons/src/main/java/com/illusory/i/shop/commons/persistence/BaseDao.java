package com.illusory.i.shop.commons.persistence;

import java.util.List;
import java.util.Map;

/**
 * 所有数据访问层基类
 *
 * @author illusoryCloud
 * @version 1.0.0
 * @date 2019/3/26 23:53
 */
public interface BaseDao<T extends BaseEntity> {
    /**
     * 查询全部数据
     *
     * @return List<T>
     */
    List<T> selectAll();

    /**
     * 新增entity
     *
     * @param entity
     */
    void insert(T entity);

    /**
     * 根据ID删除entity
     *
     * @param id entityID
     */
    void delete(Long id);

    /**
     * 根据ID查询entity
     *
     * @param id
     * @return
     */
    T getById(Long id);

    /**
     * 更新entity
     *
     * @param entity
     */
    void update(T entity);

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
    List<T> page(Map<String, Object> params);

    /**
     * 查询总记录条数
     *
     * @return
     */
    int count(T entity);
}
