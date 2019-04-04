package com.illusory.i.shop.service.user.provider.api.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.illusory.i.shop.commons.domain.TbUser;
import com.illusory.i.shop.commons.mapper.TbUserMapper;
import com.illusory.i.shop.service.user.api.TbUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import tk.mybatis.mapper.entity.Example;

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
        String username = tbUser.getUsername();
        String phone = tbUser.getPhone();
        String email = tbUser.getEmail();

        Example example = new Example(TbUser.class);
        example.createCriteria()
                .andLike("username", username != null ? username + "%" : null)
                .andLike("phone", phone != null ? phone + "%" : null)
                .andLike("email", email != null ? email + "%" : null);

        PageHelper.offsetPage(pageNum, pageSize);
        PageInfo<TbUser> pageInfo = new PageInfo<>(tbUserMapper.selectByExample(example));
        return pageInfo;
    }
}

