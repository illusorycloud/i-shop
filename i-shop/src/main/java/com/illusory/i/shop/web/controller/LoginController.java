package com.illusory.i.shop.web.controller;

import com.illusory.i.shop.commons.context.SpringContext;
import com.illusory.i.shop.commons.utils.CookieUtils;
import com.illusory.i.shop.entity.User;
import com.illusory.i.shop.service.UserService;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author illusory
 * @version 1.0.0
 * @date 2019/3/23
 */
public class LoginController extends HttpServlet {
    private static final String COOKIE_NAME_USER_INFO = "userInfo";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet");
        String userInfo = CookieUtils.getCookieValue(req, COOKIE_NAME_USER_INFO);
        if (!StringUtils.isBlank(userInfo)) {
            String[] userInfoArray = userInfo.split(":");
            String email = userInfoArray[0];
            String password = userInfoArray[1];
            req.setAttribute("email", email);
            req.setAttribute("password", password);
            req.setAttribute("isRememberMe", true);
        }
        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        //勾上记住我后isRememberMe就是on 否则是null
        boolean isRememberMe = req.getParameter("isRememberMe") != null;
        UserService userService = (UserService) SpringContext.getBean("userService");
        User admin = userService.login(email, password);
        //用户选择不记住
        if (!isRememberMe) {
            CookieUtils.deleteCookie(req, resp, COOKIE_NAME_USER_INFO);
        }
        //登录成功
        if (admin != null) {
            //勾选了记住我
            if (isRememberMe) {
                //用户信息存储一周
                CookieUtils.setCookie(req, resp, COOKIE_NAME_USER_INFO, String.format("%s:%s", email, password), 7 * 24 * 60 * 60);
            }
            resp.sendRedirect("/main.jsp");
        }
        //登录失败
        else {
            req.setAttribute("message", "用户名或密码错误");
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }
    }
}
