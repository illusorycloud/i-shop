package com.illusory.i.shop.web.admin.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author illusoryCloud
 * @version 1.0.0
 * @date 2019/3/24 17:45
 */
@Controller
public class MainController {
    /**
     * 跳转到首页
     *
     * @return
     */
    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String main() {
        return "main";
    }
}
