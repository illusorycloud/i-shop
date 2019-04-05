package com.illusory.i.shop.service.user.consumer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 * @author illusory
 * @version 1.0.0
 * @date 2019/4/4
 */
@Controller
public class MainController {

    /**
     * 跳转到首页
     *
     * @return
     */
    @RequestMapping(value = {"main", ""}, method = RequestMethod.GET)
    public String main() {
        return "user/main";
    }

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index() {
        return "user/index";
    }
}
