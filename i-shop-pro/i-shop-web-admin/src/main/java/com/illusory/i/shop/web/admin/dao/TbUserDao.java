package com.illusory.i.shop.web.admin.dao;

import com.illusory.i.shop.commons.persistence.BaseDao;
import com.illusory.i.shop.domain.TbUser;
import org.springframework.stereotype.Repository;

/**
 * @author illusory
 * @version 1.0.0
 * @date 2019/3/25
 */
@Repository
public interface TbUserDao  extends BaseDao<TbUser> {
    /**
     * 根据邮箱查询用户信息
     *
     * @param email
     * @return
     */
    TbUser getByEmail(String email);
}
