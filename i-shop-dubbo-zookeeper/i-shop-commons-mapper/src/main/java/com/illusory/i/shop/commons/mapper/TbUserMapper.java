package com.illusory.i.shop.commons.mapper;

import com.illusory.i.shop.commons.domain.TbUser;
import com.illusory.i.shop.commons.mapper.utils.RedisCache;

import org.apache.ibatis.annotations.CacheNamespace;

import tk.mybatis.mapper.MyMapper;

@CacheNamespace(implementation = RedisCache.class)
public interface TbUserMapper extends MyMapper<TbUser> {
}