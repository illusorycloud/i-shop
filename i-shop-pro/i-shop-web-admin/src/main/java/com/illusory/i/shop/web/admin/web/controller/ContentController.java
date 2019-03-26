package com.illusory.i.shop.web.admin.web.controller;

import com.illusory.i.shop.commons.dto.BaseResult;
import com.illusory.i.shop.commons.dto.PageInfo;
import com.illusory.i.shop.domain.TbContent;
import com.illusory.i.shop.web.admin.service.TbContentService;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author illusory
 * @version 1.0.0
 * @date 2019/3/26
 */
@Controller
@RequestMapping(value = "/content")
public class ContentController {
    @Autowired
    private TbContentService tbContentService;


    /**
     * @param id
     * @return
     * @ModelAttribute 自动将返回值放入Model中
     */
    @ModelAttribute
    public TbContent getTbUser(Long id) {
        TbContent tbContent = null;
        //id不为空则从数据库获取
        if (id != null) {
            tbContent = tbContentService.getById(id);
        }
        //为空则
        else {
            tbContent = new TbContent();
        }
        return tbContent;
    }

    /**
     * 跳转到内容列表
     *
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list() {
        return "content_list";
    }

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String from() {
        return "content_form";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(TbContent tbContent, RedirectAttributes redirectAttributes, Model model) {
        BaseResult baseResult = tbContentService.save(tbContent);
        //保存成功 重定向 所以用RedirectAttributes 消息存放在session中
        if (baseResult.getStatus() == BaseResult.STATUS_SUCCESS) {
            redirectAttributes.addFlashAttribute("baseResult", baseResult);
            return "redirect:/content/list";
        }
        //保存失败 跳转 可以用Model 消息存放在request中
        else {
            model.addAttribute("baseResult", baseResult);
            return "content_form";
        }
    }

    @ResponseBody
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public BaseResult delete(String ids, Model model) {
        BaseResult baseResult = null;
        if (StringUtils.isNoneBlank(ids)) {
            String[] idArray = ids.split(",");
            tbContentService.deleteMulti(idArray);
            baseResult = BaseResult.success("删除用户成功");
        } else {
            baseResult = BaseResult.fail("删除失败");
        }
        return baseResult;
    }

    /**
     * 分页查询
     *
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public PageInfo<TbContent> page(HttpServletRequest request, TbContent tbContent) {
        String strDraw = request.getParameter("draw");
        String strStart = request.getParameter("start");
        String strLength = request.getParameter("length");

        int draw = strDraw == null ? 0 : Integer.parseInt(strDraw);
        int start = strStart == null ? 0 : Integer.parseInt(strStart);
        int length = strLength == null ? 10 : Integer.parseInt(strLength);

        //封装Datatables需要的数据
        return tbContentService.page(draw, start, length, tbContent);
    }

    /**
     * 显示内容详情
     *
     * @param tbContent
     * @return
     */
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public String detail(TbContent tbContent) {
        return "content_detail";
    }
}
