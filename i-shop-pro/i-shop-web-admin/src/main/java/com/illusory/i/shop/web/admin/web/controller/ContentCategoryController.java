package com.illusory.i.shop.web.admin.web.controller;

import com.illusory.i.shop.domain.TbContentCategory;
import com.illusory.i.shop.web.admin.service.TbContentCategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * 内容分类管理
 *
 * @author illusory
 * @version 1.0.0
 * @date 2019/3/26
 */
@Controller
@RequestMapping(value = "/content/category")
public class ContentCategoryController {
    @Autowired
    private TbContentCategoryService service;


    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list(Model model) {
        List<TbContentCategory> targetList = new ArrayList<>();
        List<TbContentCategory> sourceList = service.selectAll();

        // 排序
        sortList(sourceList, targetList, 0L);

        model.addAttribute("tbContentCategories", targetList);
        return "content_category_list";
    }

    /**
     * 排序
     *
     * @param sourceList   排序前的集合
     * @param targetList 排序后的集合
     * @param parentId   父节点ID
     */
    private void sortList(List<TbContentCategory> sourceList, List<TbContentCategory> targetList, Long parentId) {
        for (TbContentCategory tbContentCategory : sourceList) {
            if (tbContentCategory.getParentId().equals(parentId)) {
                targetList.add(tbContentCategory);
                //判断有没有子节点
                if (tbContentCategory.getIsParent()) {
                    for (TbContentCategory contentCategory : sourceList) {
                        if (contentCategory.getParentId().equals(tbContentCategory.getId())) {
                            sortList(sourceList, targetList, tbContentCategory.getId());
                            break;
                        }
                    }
                }
            }

        }
    }
}
