package com.illusory.i.shop.commons.persistence;

import com.illusory.i.shop.commons.dto.BaseResult;

import java.util.List;

/**
 * 树形结构业务逻辑层基类
 *
 * @author illusory
 * @version 1.0.0
 * @date 2019/3/27
 */
public interface BaseTreeService<T extends BaseEntity> {
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
    BaseResult save(T entity);

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
     * 根据父级节点 ID 查询所有子节点
     *
     * @param pid
     * @return
     */
    List<T> selectByPid(Long pid);
}
