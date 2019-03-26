package com.illusory.i.shop.web.admin.web.controller;

import com.illusory.i.shop.commoms.constant.ConstantUtils;
import com.illusory.i.shop.commoms.utils.CookieUtils;
import com.illusory.i.shop.domain.TbUser;
import com.illusory.i.shop.web.admin.service.TbUserService;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author illusoryCloud
 * @version 1.0.0
 * @date 2019/3/24 17:42
 */
@Controller

public class LoginController {
    @Autowired
    private TbUserService tbUserService;

    @RequestMapping(value = {"", "/login"}, method = RequestMethod.GET)
    public String login(HttpServletRequest request, Model model) {
        String cookieValue = CookieUtils.getCookieValue(request, ConstantUtils.COOKIE_NAME_USER_INFO);
        if (!StringUtils.isBlank(cookieValue)) {
            model.addAttribute("isRememberMe", true);
        }
        return "login";
    }

    @ModelAttribute(value = "email")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(String email, String password, HttpServletRequest request, HttpServletResponse response, Model model) {
        //勾上记住我后isRememberMe就是on 否则是null
        boolean isRememberMe = request.getParameter("isRememberMe") != null;
        //用户选择不记住
        if (!isRememberMe) {
            CookieUtils.deleteCookie(request, response, ConstantUtils.COOKIE_NAME_USER_INFO);
        }
        TbUser tbUser = tbUserService.login(email, password);
        //登录失败
        if (tbUser == null) {
            model.addAttribute("message", "邮箱或密码错误！");
            return login(request, model);
        }
        //登录成功
        else {
            //勾选了记住我
            if (isRememberMe) {
                //用户信息存储一周
                CookieUtils.setCookie(request, response, ConstantUtils.COOKIE_NAME_USER_INFO, String.format("%s:%s", email, password), 7 * 24 * 60 * 60);
                request.getSession().setAttribute("isRememberMe", true);
            }
            //将登录信息放入会话
            request.getSession().setAttribute(ConstantUtils.SESSION_USER, tbUser);
            return "redirect:/main";
        }
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request, Model model) {
        request.getSession().invalidate();
        return login(request, model);
    }

}
