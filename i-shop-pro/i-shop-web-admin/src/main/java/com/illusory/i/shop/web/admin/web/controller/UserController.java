package com.illusory.i.shop.web.admin.web.controller;

import com.illusory.i.shop.commoms.dto.BaseResult;
import com.illusory.i.shop.domain.TbUser;
import com.illusory.i.shop.web.admin.service.TbUserService;
import com.sun.org.apache.xpath.internal.operations.Mod;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * 用户管理
 *
 * @author illusory
 * @version 1.0.0
 * @date 2019/3/25
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private TbUserService tbUserService;

    /**
     * @param id
     * @return
     * @ModelAttribute 自动将返回值放入Model中
     */
    @ModelAttribute
    public TbUser getTbUser(Long id) {
        TbUser tbUser = null;
        //id不为空则从数据库获取
        if (id != null) {
            tbUser = tbUserService.getById(id);
        }
        //为空则
        else {
            tbUser = new TbUser();
        }
        return tbUser;
    }

    /**
     * 跳转到用户列表
     *
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        List<TbUser> tbUsers = tbUserService.selectAll();
        model.addAttribute("tbUsers", tbUsers);
        return "user_list";
    }

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String from() {
        return "user_form";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(TbUser tbUser, RedirectAttributes redirectAttributes, Model model) {
        BaseResult baseResult = tbUserService.save(tbUser);
        //保存成功 重定向 所以用RedirectAttributes 消息存放在session中
        if (baseResult.getStatus() == BaseResult.STATUS_SUCCESS) {
            redirectAttributes.addFlashAttribute("baseResult", baseResult);
            return "redirect:/user/list";
        }
        //保存失败 跳转 可以用Model 消息存放在request中
        else {
            model.addAttribute("baseResult", baseResult);
            return "user_form";
        }
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String search(String keyword, Model model) {
        List<TbUser> tbUsers = tbUserService.search(keyword);
        model.addAttribute("tbUsers", tbUsers);
        return "user_list";
    }
}
