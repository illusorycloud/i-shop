package com.illusory.i.shop.service.impl;

import com.illusory.i.shop.dao.UserDao;
import com.illusory.i.shop.domain.User;
import com.illusory.i.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author illusoryCloud
 * @version 1.0.0
 * @date 2019/3/24 17:39
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User login(String email, String password) {
        return userDao.getUser(email, password);
    }
}
