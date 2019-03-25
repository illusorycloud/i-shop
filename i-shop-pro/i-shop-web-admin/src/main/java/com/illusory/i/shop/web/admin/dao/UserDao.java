package com.illusory.i.shop.web.admin.dao;

import com.illusory.i.shop.domain.User;

/**
 * @author illusoryCloud
 * @version 1.0.0
 * @date 2019/3/24 16:42
 */
public interface UserDao {
    /**
     * 根据邮箱和密码获取用户信息
     * @param email 邮箱
     * @param password 密码
     * @return User
     */
    public User getUser(String email, String password);
}
