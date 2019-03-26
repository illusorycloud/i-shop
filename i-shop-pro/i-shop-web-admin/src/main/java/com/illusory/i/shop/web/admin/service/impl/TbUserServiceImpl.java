package com.illusory.i.shop.web.admin.service.impl;

import com.illusory.i.shop.commoms.dto.BaseResult;
import com.illusory.i.shop.commoms.dto.PageInfo;
import com.illusory.i.shop.commoms.utils.RegexUtils;
import com.illusory.i.shop.web.admin.dao.TbUserDao;
import com.illusory.i.shop.domain.TbUser;
import com.illusory.i.shop.web.admin.service.TbUserService;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2019/3/25 0025
 */
@Service
public class TbUserServiceImpl implements TbUserService {
    @Autowired
    private TbUserDao tbUserDao;

    @Override
    public List<TbUser> selectAll() {
        return tbUserDao.selectAll();
    }

    @Override
    public BaseResult save(TbUser tbUser) {
        BaseResult baseResult = checkTbUser(tbUser);
        //通过验证
        if (baseResult.getStatus() == BaseResult.STATUS_SUCCESS) {
            tbUser.setUpdated(new Date());
            //密码转为MD5加密
            tbUser.setPassword(DigestUtils.md5DigestAsHex(tbUser.getPassword().getBytes()));
            //新增用户
            if (tbUser.getId() == null) {
                tbUser.setCreated(new Date());
                tbUserDao.insert(tbUser);
            }
            //编辑用户
            else {
                tbUserDao.update(tbUser);
            }
            baseResult.setMessage("保存用户信息成功");
        }
        return baseResult;
    }

    @Override
    public void delete(Long id) {
        tbUserDao.delete(id);
    }

    @Override
    public TbUser getById(Long id) {
        return tbUserDao.getById(id);
    }

    @Override
    public void update(TbUser tbUser) {
        tbUserDao.update(tbUser);
    }


    @Override
    public TbUser login(String email, String password) {
        TbUser tbUser = tbUserDao.getByEmail(email);
        if (tbUser != null) {
            //明文密码加密
            String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());
            //判断与数据库中密码是否匹配
            if (md5Password.equals(tbUser.getPassword())) {
                return tbUser;
            }
        }
        return null;
    }

    @Override
    public void deleteMulti(String[] ids) {
        tbUserDao.deleteMulti(ids);
    }

    @Override
    public PageInfo<TbUser> page(int draw, int start, int length, TbUser tbUser) {
        Map<String, Object> params = new HashMap<>(2);
        params.put("start", start);
        params.put("length", length);
        params.put("tbUser", tbUser);

        int count = tbUserDao.count(tbUser);
        PageInfo<TbUser> pageInfo = new PageInfo<>();
        pageInfo.setDraw(draw);
        pageInfo.setRecordsTotal(count);
        pageInfo.setRecordsFiltered(count);
        pageInfo.setData(tbUserDao.page(params));
        return pageInfo;
    }

    @Override
    public int count(TbUser tbUser) {
        return tbUserDao.count(tbUser);
    }

    /**
     * 用户信息有效性验证
     *
     * @param tbUser
     */
    private BaseResult checkTbUser(TbUser tbUser) {
        //默认为success
        BaseResult baseResult = BaseResult.success();
        if (StringUtils.isBlank(tbUser.getEmail())) {
            baseResult = BaseResult.fail("邮箱不能为空,请重新输入");
        } else if (!RegexUtils.isEmail(tbUser.getEmail())) {
            baseResult = BaseResult.fail("邮箱格式不正确,请重新输入");
        } else if (StringUtils.isBlank(tbUser.getPassword())) {
            baseResult = BaseResult.fail("密码不能为空,请重新输入");
        } else if (StringUtils.isBlank(tbUser.getUsername())) {
            baseResult = BaseResult.fail("姓名不能为空,请重新输入");
        } else if (StringUtils.isBlank(tbUser.getPhone())) {
            baseResult = BaseResult.fail("手机号不能为空,请重新输入");
        } else if (!RegexUtils.isMobileSimple(tbUser.getPhone())) {
            baseResult = BaseResult.fail("手机号格式不正确,请重新输入");
        }
        return baseResult;
    }
}
