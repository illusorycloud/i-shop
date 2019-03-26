package com.illusory.i.shop.web.admin.service;

import com.illusory.i.shop.commons.persistence.BaseService;
import com.illusory.i.shop.domain.TbUser;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2019/3/25 0025
 */
public interface TbUserService extends BaseService<TbUser> {
    /**
     * 登录
     *
     * @param email
     * @param password
     * @return
     */
    TbUser login(String email, String password);
}
