package com.illusory.i.shop.web.admin.service.impl;

import com.illusory.i.shop.commons.dto.BaseResult;
import com.illusory.i.shop.commons.validator.BeanValidator;
import com.illusory.i.shop.domain.TbContent;
import com.illusory.i.shop.web.admin.abstracts.AbstractBaseServiceImpl;
import com.illusory.i.shop.web.admin.dao.TbContentDao;
import com.illusory.i.shop.web.admin.service.TbContentService;

import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author illusory
 * @version 1.0.0
 * @date 2019/3/26
 */
@Service
//@Transactional(readOnly = true)
public class TbContentServiceImpl extends AbstractBaseServiceImpl<TbContent, TbContentDao> implements TbContentService {

    @Override
//    @Transactional(readOnly = false)
    public BaseResult save(TbContent tbContent) {
        String validator = BeanValidator.validator(tbContent);

        // 验证不通过
        if (validator != null) {
            return BaseResult.fail(validator);
        }

        // 验证通过
        else {
            tbContent.setUpdated(new Date());

            // 新增
            if (tbContent.getId() == null) {
                // 密码需要加密处理
                tbContent.setCreated(new Date());
                dao.insert(tbContent);
            }

            // 编辑用户
            else {
                update(tbContent);
            }

            return BaseResult.success("保存内容信息成功");
        }
    }

    @Override
//    @Transactional(readOnly = false)
    public void deleteByCategoryId(String[] categoryIds) {
        dao.deleteByCategoryId(categoryIds);
    }
}

