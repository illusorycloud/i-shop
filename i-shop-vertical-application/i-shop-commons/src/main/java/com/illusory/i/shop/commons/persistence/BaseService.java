package com.illusory.i.shop.commons.persistence;

import com.illusory.i.shop.commons.dto.BaseResult;
import com.illusory.i.shop.commons.dto.PageInfo;

import java.util.List;

/**
 * 所有业务逻辑层的基类
 *
 * @author illusoryCloud
 * @version 1.0.0
 * @date 2019/3/26 23:59
 */
public interface BaseService<T extends BaseEntity> {
    /**
     * 查询所有数据
     *
     * @return
     */
    public List<T> selectAll();

    /**
     * 保存信息
     *
     * @param entity
     * @return
     */
    BaseResult save(T entity);

    /**
     * 根据ID删除entity
     *
     * @param id
     */
    void delete(Long id);

    /**
     * 根据ID获取entity
     *
     * @param id
     */
    T getById(Long id);

    /**
     * 更新用户信息
     *
     * @param entity
     */
    void update(T entity);

    /**
     * 批量删除
     *
     * @param ids ID数组
     */
    void deleteMulti(String[] ids);

    /**
     * 分页查询
     *
     * @param start
     * @param length
     * @param draw
     * @param entity
     * @return
     */
    PageInfo<T> page(int start, int length, int draw, T entity);

    /**
     * 查询总记录条数 用于分页
     *
     * @param entity
     * @return
     */
    int count(T entity);
}
