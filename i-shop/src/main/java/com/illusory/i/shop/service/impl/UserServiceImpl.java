package com.illusory.i.shop.service.impl;

import com.illusory.i.shop.commons.context.SpringContext;
import com.illusory.i.shop.dao.UserDao;
import com.illusory.i.shop.entity.User;
import com.illusory.i.shop.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author illusory
 * @version 1.0.0
 * @date 2019/3/23 0023
 */
@Service(value = "userService")
public class UserServiceImpl implements UserService {

    public User login(String email, String password) {
        UserDao userDao = SpringContext.getBean("userDao");
        return userDao.getUser(email, password);
    }
}
