package com.illusory.i.shop.service.user.provider.api.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageInfo;
import com.illusory.i.shop.commons.domain.TbUser;
import com.illusory.i.shop.commons.mapper.TbUserMapper;
import com.illusory.i.shop.service.user.api.TbUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author illusory
 * @version 1.0.0
 * @date 2019/4/2
 */
@Service(version = "${services.versions.user.v1}")
@Transactional(readOnly = true)
public class TbUserServiceImpl implements TbUserService {
    @Autowired
    private TbUserMapper tbUserMapper;

    @Override
    public List<TbUser> selectAll() {
        return tbUserMapper.selectAll();
    }

    @Override
    public PageInfo<TbUser> page(int pageNum, int pageSize, TbUser tbUser) {
        return null;
    }
}
