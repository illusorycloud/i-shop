package com.illusory.i.shop.web.admin.service;

import com.illusory.i.shop.domain.User;

/**
 * @author illusoryCloud
 * @version 1.0.0
 * @date 2019/3/24 17:38
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
