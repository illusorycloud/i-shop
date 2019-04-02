package com.illusory.i.shop.service;

import com.illusory.i.shop.entity.User;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2019/3/23 0023
 */
public interface UserService {
    /**
     * 用户登陆
     * @param email 邮箱
     * @param password 密码
     * @return User
     */
    public User login(String email, String password);
}
