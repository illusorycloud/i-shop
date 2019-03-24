package com.illusory.i.shop.service;

import com.illusory.i.shop.entity.User;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2019/3/23 0023
 */
public interface UserService {
    public User login(String email, String password);
}
