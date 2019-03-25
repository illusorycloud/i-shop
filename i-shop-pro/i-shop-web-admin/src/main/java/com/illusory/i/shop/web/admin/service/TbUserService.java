package com.illusory.i.shop.web.admin.service;

import com.illusory.i.shop.domain.TbUser;

import java.util.List;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2019/3/25 0025
 */
public interface TbUserService {
    public List<TbUser> selectAll();

    void insert(TbUser tbUser);

    void delete(Long id);

    TbUser getById(Long id);

    void update(TbUser tbUser);

    List<TbUser> selectByUsername(String username);

    TbUser login(String email,String password);
}
