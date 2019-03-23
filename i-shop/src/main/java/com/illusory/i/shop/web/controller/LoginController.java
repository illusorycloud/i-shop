package com.illusory.i.shop.web.controller;

import com.illusory.i.shop.commons.context.SpringContext;
import com.illusory.i.shop.entity.User;
import com.illusory.i.shop.service.UserService;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2019/3/23 0023
 */
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        UserService userService = (UserService) SpringContext.getBean("userService");
        User admin = userService.login(email, password);
        //登录成功
        if (admin != null) {
            resp.sendRedirect("/main.jsp");
        }
        //登录失败
        else {
            req.setAttribute("message", "用户名或密码错误");
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }
    }
}
