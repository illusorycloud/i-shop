package com.illusory.i.shop.web.admin.service.impl;

import com.illusory.i.shop.commons.dto.BaseResult;
import com.illusory.i.shop.commons.dto.PageInfo;
import com.illusory.i.shop.commons.utils.RegexUtils;
import com.illusory.i.shop.commons.validator.BeanValidator;
import com.illusory.i.shop.domain.TbContent;
import com.illusory.i.shop.web.admin.dao.TbContentDao;
import com.illusory.i.shop.web.admin.service.TbContentService;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2019/3/26 0026
 */
@Service
public class TbContentServiceImpl implements TbContentService {
    @Autowired
    private TbContentDao tbContentDao;

    @Override
    public List<TbContent> selectAll() {
        return tbContentDao.selectAll();
    }

    @Override
    public BaseResult save(TbContent tbContent) {
        String validator = BeanValidator.validator(tbContent);
        //验证失败
        if (validator != null) {
            return BaseResult.fail(validator);
        }
        //通过验证
        else {
            tbContent.setUpdated(new Date());
            //新增内容
            if (tbContent.getId() == null) {
                tbContent.setCreated(new Date());
                tbContentDao.insert(tbContent);
            }
            //编辑内容
            else {
                tbContentDao.update(tbContent);
            }
            return BaseResult.success("保存内容信息成功");
        }
    }

    @Override
    public void delete(Long id) {
        tbContentDao.delete(id);
    }

    @Override
    public TbContent getById(Long id) {
        return tbContentDao.getById(id);
    }

    @Override
    public void update(TbContent tbContent) {
        tbContentDao.update(tbContent);
    }

    @Override
    public List<TbContent> search(TbContent tbContent) {
        return tbContentDao.search(tbContent);
    }

    @Override
    public void deleteMulti(String[] ids) {
        tbContentDao.deleteMulti(ids);
    }

    @Override
    public PageInfo<TbContent> page(int start, int length, int draw, TbContent tbContent) {
        Map<String, Object> params = new HashMap<>(3);
        params.put("start", start);
        params.put("length", length);
        params.put("tbContent", tbContent);
        int count = tbContentDao.count(tbContent);
        PageInfo<TbContent> pageInfo = new PageInfo<>();
        pageInfo.setDraw(draw);
        pageInfo.setRecordsTotal(count);
        pageInfo.setRecordsFiltered(count);
        pageInfo.setData(tbContentDao.page(params));
        return pageInfo;
    }


    @Override
    public int count(TbContent tbContent) {
        return tbContentDao.count(tbContent);
    }

}
