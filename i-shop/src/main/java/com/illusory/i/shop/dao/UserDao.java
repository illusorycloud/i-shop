package com.illusory.i.shop.dao;

import com.illusory.i.shop.entity.User;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2019/3/23 0023
 */
public interface UserDao {
    public User getUser(String email,String password);
}
