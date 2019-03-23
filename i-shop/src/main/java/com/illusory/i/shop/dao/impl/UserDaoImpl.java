package com.illusory.i.shop.dao.impl;

import com.illusory.i.shop.dao.UserDao;
import com.illusory.i.shop.entity.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2019/3/23 0023
 */
public class UserDaoImpl implements UserDao {
    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    public User getUser(String email, String password) {
        logger.info("调用 getUser()方法 email:{} password:{}", email, password);
        User user = null;
        if ("admin@illusory.com".equals(email)) {
            if ("admin".equals(password)) {
                user = new User();
                user.setEmail(email);
                user.setUsername("illusory");
                logger.info("成功获取 \" {}\" 的用户信息", user.getUsername());
            }
        } else {
            logger.info("获取 \" {}\" 的用户信息失败", email);

        }
        return user;
    }
}
