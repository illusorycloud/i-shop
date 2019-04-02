package com.illusory.i.shop.web.api.service;


import com.illusory.i.shop.domain.TbUser;

/**
 * @author illusory
 * @version 1.0.0
 * @date 2019/3/27
 */
public interface TbUserService {

    /**
     * 登录
     * @param tbUser
     * @return
     */
    TbUser login(TbUser tbUser);
}
