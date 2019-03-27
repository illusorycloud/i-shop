package com.illusory.i.shop.web.ui.api;


import com.illusory.i.shop.commons.utils.HttpClientUtils;
import com.illusory.i.shop.commons.utils.MapperUtils;
import com.illusory.i.shop.web.ui.dto.TbContent;

import java.util.List;

/**
 * 内容管理接口
 *
 * @author illusoryCloud
 * @version 1.0.0
 * @date 2019/3/27
 */
public class ContentsApi {

    /**
     * 请求幻灯片
     *
     * @return
     */
    public static List<TbContent> ppt() {
        List<TbContent> tbContents = null;
        String result = HttpClientUtils.doGet(API.API_CONTENTS_PPT);
        try {
            tbContents = MapperUtils.json2listByTree(result, "data", TbContent.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tbContents;
    }
}
