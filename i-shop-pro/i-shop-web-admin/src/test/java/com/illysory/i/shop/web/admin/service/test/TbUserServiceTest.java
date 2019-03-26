package com.illysory.i.shop.web.admin.service.test;

import com.illusory.i.shop.domain.TbUser;
import com.illusory.i.shop.web.admin.service.TbUserService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2019/3/25 0025
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-context.xml", "classpath:spring-context-druid.xml", "classpath:spring-context-mybatis.xml"})
public class TbUserServiceTest {
    @Autowired
    private TbUserService tbUserService;

    @Test
    public void testSelectAll() {
        List<TbUser> tbUsers = tbUserService.selectAll();
        for (TbUser t : tbUsers
        ) {
            System.out.println(t.toString());
        }
    }

    @Test
    public void testInsert() {
        TbUser tbUser = new TbUser();
        tbUser.setUsername("illusory");
        tbUser.setPassword(DigestUtils.md5DigestAsHex("123456".getBytes()));
        tbUser.setPhone("123456789");
        tbUser.setEmail("illusory@azz.com");
        tbUser.setCreated(new Date());
        tbUser.setUpdated(new Date());
        tbUserService.save(tbUser);
    }

    @Test
    public void testDelete() {
        tbUserService.delete(38L);
    }

    @Test
    public void testGetById() {
        TbUser tbUser = tbUserService.getById(36L);
        System.out.println(tbUser.toString());
    }

    @Test
    public void testUpdate() {
        TbUser tbUser = tbUserService.getById(41L);
        tbUser.setPassword(DigestUtils.md5DigestAsHex("123456".getBytes()));
        tbUserService.update(tbUser);
    }

    @Test
    public void testMd5(){
        System.out.println(DigestUtils.md5DigestAsHex("123456".getBytes()));
    }

}
