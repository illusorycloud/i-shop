package com.illusory.i.shop.service.user.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.illusory.i.shop.commons.domain.TbUser;
import com.illusory.i.shop.service.user.api.TbUserService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author illusory
 * @version 1.0.0
 * @date 2019/4/2
 */
@Controller
public class TbUserController {
    @Reference(version = "${services.versions.user.v1}")
    private TbUserService tbUserService;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list(Model model) {
        List<TbUser> tbUsers = tbUserService.selectAll();
        model.addAttribute("tbUsers", tbUsers);
        return "user/list";
    }
}
