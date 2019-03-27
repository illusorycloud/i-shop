package com.illusory.i.shop.web.api.dao;

import com.illusory.i.shop.domain.TbUser;

import org.springframework.stereotype.Repository;

/**
 * @author illusory
 * @version 1.0.0
 * @date 2019/3/27
 */
@Repository
public interface TbUserDao {
    /**
     * 登录
     *
     * @param tbUser
     * @return
     */
    TbUser login(TbUser tbUser);
}
