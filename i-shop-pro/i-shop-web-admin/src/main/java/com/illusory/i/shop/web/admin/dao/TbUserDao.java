package com.illusory.i.shop.web.admin.dao;

import com.illusory.i.shop.domain.TbUser;

import org.junit.Test;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author illusory
 * @version 1.0.0
 * @date 2019/3/25
 */
@Repository
public interface TbUserDao {
    /**
     * 查询用户表全部信息
     *
     * @return List<TbUser>
     */
    List<TbUser> selectAll();

    /**
     * 新增
     *
     * @param tbUser
     */
    void insert(TbUser tbUser);

    /**
     * 删除
     *
     * @param id 用户id
     */
    void delete(Long id);

    /**
     * 根据ID查询用户信息
     *
     * @param id
     * @return
     */
    TbUser getById(Long id);

    /**
     * 更新用户信息
     *
     * @param tbUser
     */
    void update(TbUser tbUser);

    /**
     * 根据用户名进行模糊查询
     *
     * @param username
     * @return
     */
    List<TbUser> selectByUsername(String username);

    /**
     * 根据邮箱查询用户信息
     *
     * @param email
     * @return
     */
    TbUser getByEmail(String email);

    /**
     * 搜索
     *
     * @return
     */
    List<TbUser> search(TbUser tbUser);
}
