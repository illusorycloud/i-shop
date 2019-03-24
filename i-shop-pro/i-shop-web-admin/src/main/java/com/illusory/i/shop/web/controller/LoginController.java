package com.illusory.i.shop.web.controller;

import com.illusory.i.shop.commoms.constant.ConstantUtils;
import com.illusory.i.shop.commoms.utils.CookieUtils;
import com.illusory.i.shop.domain.User;
import com.illusory.i.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    private UserService userService;

    @RequestMapping(value = {"", "/login"}, method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(String email, String password, HttpServletRequest request, HttpServletResponse response) {
        //勾上记住我后isRememberMe就是on 否则是null
        boolean isRememberMe = request.getParameter("isRememberMe") != null;
        //用户选择不记住
        if (!isRememberMe) {
            CookieUtils.deleteCookie(request, response, ConstantUtils.COOKIE_NAME_USER_INFO);
        }
        User user = userService.login(email, password);
        if (user == null) {
            return login();
        }
        //登录成功
        else {
            //勾选了记住我
            if (isRememberMe) {
                //用户信息存储一周
                CookieUtils.setCookie(request, response, ConstantUtils.COOKIE_NAME_USER_INFO, String.format("%s:%s", email, password), 7 * 24 * 60 * 60);
            }
            //将登录信息放入会话
            request.getSession().setAttribute(ConstantUtils.SESSION_USER, user);
            return "redirect:/main";
        }
    }

}
