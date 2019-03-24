package com.illusory.i.shop.service.impl;

import com.illusory.i.shop.dao.UserDao;
import com.illusory.i.shop.entity.User;
import com.illusory.i.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author illusory
 * @version 1.0.0
 * @date 2019/3/23 0023
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    public User login(String email, String password) {
        return userDao.getUser(email, password);
    }
}
