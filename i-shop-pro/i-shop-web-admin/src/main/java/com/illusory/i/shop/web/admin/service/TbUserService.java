package com.illusory.i.shop.web.admin.service;

import com.illusory.i.shop.commons.dto.BaseResult;
import com.illusory.i.shop.commons.dto.PageInfo;
import com.illusory.i.shop.domain.TbUser;

import java.util.List;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2019/3/25 0025
 */
public interface TbUserService {
    /**
     * 查询所有
     *
     * @return
     */
    public List<TbUser> selectAll();

    /**
     * 保存用户信息
     *
     * @param tbUser
     * @return
     */
    BaseResult save(TbUser tbUser);

    /**
     * 根据ID删除用户
     *
     * @param id
     */
    void delete(Long id);

    /**
     * 根据ID获取用户
     *
     * @param id
     */
    TbUser getById(Long id);

    /**
     * 更新用户信息
     *
     * @param tbUser
     */
    void update(TbUser tbUser);

    /**
     * 登录
     *
     * @param email
     * @param password
     * @return
     */
    TbUser login(String email, String password);

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
     * @param tbUser
     * @return
     */
    PageInfo<TbUser> page(int start, int length, int draw, TbUser tbUser);

    /**
     * 查询总记录条数 用于分页
     *
     * @param tbUser
     * @return
     */
    int count(TbUser tbUser);
}
