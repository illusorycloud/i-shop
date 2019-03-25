package com.illusory.i.shop.web.admin.dao.impl;

import com.illusory.i.shop.web.admin.dao.UserDao;
import com.illusory.i.shop.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * @author illusoryCloud
 * @version 1.0.0
 * @date 2019/3/24 16:43
 */
@Repository
public class UserDaoImpl implements UserDao {
    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    @Override
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
