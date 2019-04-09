package com.illusory.i.shop.service.search.provider.mapper;

import com.illusory.i.shop.service.search.domain.TbItemResult;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author illusory
 * @version 1.0.0
 * @date 2019/4/9
 */
@Repository
public interface TbItemResultMapper {
    List<TbItemResult> selectAll();
}
