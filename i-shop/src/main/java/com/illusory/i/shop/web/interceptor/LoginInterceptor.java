package com.illusory.i.shop.web.interceptor;

import com.illusory.i.shop.commons.constant.ConstantUtils;
import com.illusory.i.shop.entity.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author illusoryCloud
 * @version 1.0.0
 * @date 2019/3/24 13:38
 */
public class LoginInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        User user = (User) httpServletRequest.getSession().getAttribute(ConstantUtils.SESSION_USER);
        //未登录则跳转去登录
        if (user == null) {
            httpServletResponse.sendRedirect("/login");
        }
        //已登录则放行
        return true;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object
            o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse
            httpServletResponse, Object o, Exception e) throws Exception {

    }
}
