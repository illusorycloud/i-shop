package com.illusory.i.shop.service.user.api;

import com.github.pagehelper.PageInfo;
import com.illusory.i.shop.commons.domain.TbUser;

import java.util.List;

/**
 * @author illusory
 * @version 1.0.0
 * @date 2019/4/2
 */
public interface TbUserService {
    /**
     * 查询全部数据
     * @return
     */
    List<TbUser> selectAll();

    /**
     * 查询分页数据
     * @param pageNum 页码
     * @param pageSize 笔数
     * @param tbUser 查询参数
     * @return
     */
    PageInfo<TbUser> page(int pageNum, int pageSize, TbUser tbUser);
}
