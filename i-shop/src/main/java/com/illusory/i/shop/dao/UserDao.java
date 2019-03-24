package com.illusory.i.shop.dao;

import com.illusory.i.shop.entity.User;

/**
 * @author illusory
 * @version 1.0.0
 * @date 2019/3/23
 */
public interface UserDao {
    /**
     * 根据邮箱和密码获取用户信息
     * @param email 邮箱
     * @param password 密码
     * @return User
     */
    public User getUser(String email,String password);
}
