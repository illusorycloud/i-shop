package com.illusory.i.shop.web.admin.service.impl;

import com.illusory.i.shop.commoms.dto.BaseResult;
import com.illusory.i.shop.commoms.dto.PageInfo;
import com.illusory.i.shop.commoms.utils.RegexUtils;
import com.illusory.i.shop.domain.TbContent;
import com.illusory.i.shop.domain.TbUser;
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
        BaseResult baseResult = checkTbUser(tbContent);
        //通过验证
        if (baseResult.getStatus() == BaseResult.STATUS_SUCCESS) {
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
            baseResult.setMessage("保存内容信息成功");
        }
        return baseResult;
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


    /**
     * 有效性验证
     *
     * @param tbContent
     */
    private BaseResult checkTbUser(TbContent tbContent) {
        //默认为success
        BaseResult baseResult = BaseResult.success();
        if (StringUtils.isBlank(tbContent.getPic())) {
            baseResult = BaseResult.fail("邮箱不能为空,请重新输入");
        } else if (!RegexUtils.isEmail(tbContent.getPic2())) {
            baseResult = BaseResult.fail("邮箱格式不正确,请重新输入");
        } else if (StringUtils.isBlank(tbContent.getSubTitle())) {
            baseResult = BaseResult.fail("密码不能为空,请重新输入");
        } else if (StringUtils.isBlank(tbContent.getTitle())) {
            baseResult = BaseResult.fail("姓名不能为空,请重新输入");
        } else if (StringUtils.isBlank(tbContent.getTitleDesc())) {
            baseResult = BaseResult.fail("手机号不能为空,请重新输入");
        }
        return baseResult;
    }
}
